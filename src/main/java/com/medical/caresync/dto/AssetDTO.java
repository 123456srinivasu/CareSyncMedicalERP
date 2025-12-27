package com.medical.caresync.dto;

public class AssetDTO {
    private String assetName;
    private Long quantity;
    private Double amount;

    public AssetDTO(String assetName, Long quantity, Double amount) {
        this.assetName = assetName;
        this.quantity = quantity;
        this.amount = amount;
    }

    // Getters and Setters
    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}