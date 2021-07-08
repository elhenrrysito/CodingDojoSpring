package com.henrry.waterbnb.services;

import com.henrry.waterbnb.models.Pool;
import com.henrry.waterbnb.models.User;
import com.henrry.waterbnb.repositories.BaseRepository;
import com.henrry.waterbnb.repositories.PoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoolService extends BaseService<Pool> {
    private final PoolRepository poolRepository;

    public PoolService(PoolRepository baseRepository) {
        super(baseRepository);
        this.poolRepository = baseRepository;
    }

    public List<Pool> poolByAddress(String address) {
        return poolRepository.findByAddressContaining(address);
    }

//    public List<Pool> allUserPools(User host) {
//        System.out.println(host.getFirstName());
//        return poolRepository.findByHostsContains(host);
//    }
}
