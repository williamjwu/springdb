package io.williamwu.springdb.servicestudent.service;

import entity.Subject;
import io.williamwu.springdb.servicestudent.mapper.BridgeMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BridgeService {

    @Resource
    private BridgeMapper mapper;



}
