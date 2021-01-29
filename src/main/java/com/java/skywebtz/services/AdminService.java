package com.java.skywebtz.services;

import com.java.skywebtz.dto.AdminDTO;
import com.java.skywebtz.models.AdminModel;
import com.java.skywebtz.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public String method1(Long value) {
        // emulate heavy remote call
        try {
            Thread.sleep(Double.valueOf(Math.random()*2000).longValue() ) ;
        } catch (InterruptedException e) {
            // ignore
        }
        return "Hello, " + value + "!";
    }

    public String method2(Long value) {
        // emulate heavy remote call
        try {
            Thread.sleep(Double.valueOf(Math.random()*2000).longValue() ) ;
        } catch (InterruptedException e) {
            // ignore
        }
        return value + "*2 = " + (value * 2) + ".";
    }

    public String combine(String s1, String s2) {
        return s1 + " " + s2;
    }


    @Transactional(readOnly = true)
    public List<AdminDTO> show(List<Long> longs) {

        List<AdminDTO> adminDTOList = new ArrayList();

        if (longs.size() == 0) {
            List<AdminModel> adminModelList = adminRepository.findAll();
            for (AdminModel adminModel: adminModelList) {
                AdminDTO adminDTO = new AdminDTO(adminModel.getValue(), adminModel.getMessage(), adminModel.getTime());
                adminDTOList.add(adminDTO);
            }
        } else {
            for (Long it: longs) {
                if (!adminRepository.existsByValue(it)) {
                    continue;
                }
                AdminModel adminModel = adminRepository.findByValue(it);
                AdminDTO adminDTO = new AdminDTO(adminModel.getValue(), adminModel.getMessage(), adminModel.getTime());
                adminDTOList.add(adminDTO);
            }
        }

        return adminDTOList;
    }

    @Transactional
    public HashMap<Long, String> add(List<Long> longs) throws InterruptedException, ExecutionException {
        HashMap<Long, String > map = new HashMap<Long, String >();

        for(Long it: longs) {
            ExecutorService service = Executors.newFixedThreadPool(2);
            Future<String> future = service.submit(() -> {
                return method1(it);
            });

            Future<String> future2 = service.submit(() -> {
                return method2(it);
            });

            String res1 = future.get();
            String res2 = future2.get();
            String res = combine(res1, res2);

            if (!adminRepository.existsByValue(it)) {
                AdminModel adminModel = new AdminModel(it, res, System.currentTimeMillis());
                adminRepository.save(adminModel);
            }

            if (map.get(it) == null) {
                map.put(it, res);
            } else {
                String curr = map.get(it);
                map.put(it, curr + res);
            }
        }

        return map;
    }
}
