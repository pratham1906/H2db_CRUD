package com.h2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.entity.Asset;
import com.h2.service.AssetService;

@RestController
public class AssetController {
	@Autowired
	private AssetService assetService;
	
	
	@PostMapping("/addAsset")
	public Asset addAsset(@RequestBody Asset asset) {
	return assetService.createAsset(asset);	
	}
	
	
	@PostMapping("/addAssets")
	public List<Asset> addUsers(@RequestBody List<Asset> assets){
		return assetService.createAssets(assets);
	}
	
	
	@GetMapping("/asset/{id}")
	public Asset getAssetById(@PathVariable int id) {
	return assetService.getAssetById(id);	
	}
	
	@GetMapping("/assets")
	public List<Asset> getAllAssets(){
		return assetService.getAssets();	
	}
	
	    @PutMapping("/updateAsset")
		public Asset updateAsset(@RequestBody Asset asset) {
		return assetService.updateAsset(asset);	
	}
	    
	    @DeleteMapping("/deleteAsset/{id}")
	    public String deleteAsset(@PathVariable int id) {
	    	return assetService.deleteAssetById(id);
	    }
	    
	    @GetMapping("/searcAsset/{name}")
	    public List<String> searchAsset(@RequestBody String name){
	    	return assetService.searchAssetByName(name);
	    }
}
