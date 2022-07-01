package com.h2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.dao.AssetRepo;
import com.h2.entity.Asset;
import com.h2.entity.Asset.statusType;

@Service
public class AssetService {

	
	@Autowired
	private AssetRepo assetRepo;
    
    public Asset createAsset(Asset asset) {
    	return assetRepo.save(asset);
    }
    
    public List<Asset> createAssets(List<Asset> assets) {
    	return assetRepo.saveAll(assets);
    }
    
    public Asset getAssetById(int id) {
    	return assetRepo.findById(id).orElse(null);
    }
    public List<Asset> getAssets() {
    	return assetRepo.findAll();
    }
    
    public Asset updateAsset(Asset asset) {
    	Asset temp;
    	Optional<Asset> optionalAsset=assetRepo.findById(asset.getId());
    
    	if(optionalAsset.isPresent()) {
    	Asset oldAsset=optionalAsset.get();
    		temp=oldAsset;
    		oldAsset.setName(asset.getName());
    		oldAsset.setPurchaseDate(asset.getPurchaseDate());
    		oldAsset.setCondNotes(asset.getCondNotes());
    		oldAsset.setCategory(asset.getCategory());
    		assetRepo.save(oldAsset);
    	}
    	else {
    		return new Asset();
    	}
    	return temp;
    }
    public String deleteAssetById(int id) {
    	Optional<Asset> asset=assetRepo.findById(id);
    	Asset temp=asset.get();
    	if(temp.getStatus().equals(statusType.Assigned)) {
    		return "Asset is already Assigned!You cannot delete it";
    	}
    	assetRepo.deleteById(id);
    	return "Asset got deleted";
    }
    public List<String> searchAssetByName(String name){
    	AssetService s=new AssetService();
    	List<String> output=new ArrayList<>();
    	List<Asset> allAssets=s.getAssets();
    	for(int i=0;i<allAssets.size();i++) {
    		if(allAssets.get(i).getName().contains(name)) {
    			output.add(allAssets.get(i).getName());
    		}
    	}
    	return output;
    }
}
