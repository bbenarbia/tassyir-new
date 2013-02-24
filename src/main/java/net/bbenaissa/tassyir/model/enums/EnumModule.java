package net.bbenaissa.tassyir.model.enums;

public enum EnumModule {

	 VE("enum_module_ve");

	    private String labelKey;

	    private EnumModule(String labelKey) {
	        this.labelKey = labelKey;
	    }

	    public String getLabelKey() {
	        return labelKey;
	    }
}