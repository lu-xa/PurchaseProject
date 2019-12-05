package com.turing.entity;

public class Material {
    private Long id;//序号

    private String materialNum;//物资编码

    private String materialName;//物资名称

    private String materialUnit;//计量单位

    private String materialType;//物资类别
    
    private SysCodes codes;//对应的代码类
    
    

    

	public SysCodes getCodes() {
		return codes;
	}

	public void setCodes(SysCodes codes) {
		this.codes = codes;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}