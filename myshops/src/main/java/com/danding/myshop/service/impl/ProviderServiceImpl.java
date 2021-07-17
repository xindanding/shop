package com.danding.myshop.service.impl;

import com.danding.myshop.entity.Provider;
import com.danding.myshop.mapper.ProviderMapper;
import com.danding.myshop.service.ProviderService;
import com.danding.myshop.utils.ConstantsType;
import com.danding.myshop.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public List<Provider> getAllProvider(Map<String, Object> params) {
        int page = ConstantsType.PAGE;
        int pageSize = ConstantsType.PAGE_SIZE;
        if(params.get("page") != null){
            page = Integer.valueOf((String)params.get("page"));
        }
        if(params.get("pageSize") != null){
            pageSize =  Integer.valueOf((String)params.get("pageSize"));
        }
        List<Provider> providers = providerMapper.getAllProvider(params, (page - 1)*pageSize, pageSize);
        return providers;
    }

    @Override
    public void addProvider(Provider provider) {

        String providerNo = provider.getProviderNo();
        Provider providerData = providerMapper.findProviderByColumn("providerNo", providerNo);
        if(providerData != null){
            throw new MyException("该供应商编号已经存在");
        }
        providerMapper.addProvider(provider);
    }

    @Override
    public Provider getProviderById(Long id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public void updateProvider(Provider provider) {
        providerMapper.updateProvier(provider);
    }

    @Override
    public void deleteProviderById(Long id) {
        providerMapper.deleteProviderById(id);
    }

    @Override
    public Provider getProviderByColumn(String columnN, String columnV) {
        return providerMapper.getProviderByColumn(columnN, columnV);
    }

}
