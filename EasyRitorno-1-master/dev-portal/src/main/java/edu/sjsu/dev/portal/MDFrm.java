package edu.sjsu.dev.portal;




public class MDFrm {

    private boolean store;
    
    
    private String entityId;
    
    private String config;
    
    
    
    private String sslHstNameVerif;
    
    
    private String base_url;
    
    
    private String sign_Algo;
    
    
    private String alias;
    private String secProf;
    private boolean signMetadata;
    private boolean req_artif_res_sign;
    private String encry_Key;
    
    private String serialize_Meta_data;
    private String[] name_id;
    private String sslSecProf;
    
    private boolean inc_dsc_ext = false;
    private String cus_Disc_Resp_url;
    private boolean inc_Discvry = true;
    private String tls_key;

    private boolean lcl;

    private boolean req_Assert_sign;
    

    private String cus_Disc_url;
   
    private String sign_key;

    private boolean req_sign = true;
    
    private boolean req_logout_Req_sign;
    
    

    
    private boolean req_Logout_resp_sign;
    
    
    public MDFrm() {
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isSignMetadata() {
        return signMetadata;
    }

    public void setSignMetadata(boolean signMetadata) {
        this.signMetadata = signMetadata;
    }

    public boolean isReq_sign() {
        return req_sign;
    }

    public void setReq_sign(boolean requestSigned) {
        this.req_sign = requestSigned;
    }

    public boolean isReq_Assert_sign() {
        return req_Assert_sign;
    }

    public void setReq_Assert_sign(boolean wantAssertionSigned) {
        this.req_Assert_sign = wantAssertionSigned;
    }

    public boolean isReq_logout_Req_sign() {
        return req_logout_Req_sign;
    }

    public void setReq_logout_Req_sign(boolean requireLogoutRequestSigned) {
        this.req_logout_Req_sign = requireLogoutRequestSigned;
    }

    public boolean isReq_Logout_resp_sign() {
        return req_Logout_resp_sign;
    }

    public void setReq_Logout_resp_sign(boolean requireLogoutResponseSigned) {
        this.req_Logout_resp_sign = requireLogoutResponseSigned;
    }

    public boolean isReq_artif_res_sign() {
        return req_artif_res_sign;
    }

    public void setReq_artif_res_sign(boolean requireArtifactResolveSigned) {
        this.req_artif_res_sign = requireArtifactResolveSigned;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public String getSerialize_Meta_data() {
        return serialize_Meta_data;
    }

    public void setSerialize_Meta_data(String serializedMetadata) {
        this.serialize_Meta_data = serializedMetadata;
    }

    public String getSign_key() {
        return sign_key;
    }

    public void setSign_key(String signingKey) {
        this.sign_key = signingKey;
    }

    public String getEncry_Key() {
        return encry_Key;
    }

    public void setEncry_Key(String encryptionKey) {
        this.encry_Key = encryptionKey;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String baseURL) {
        this.base_url = baseURL;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String configuration) {
        this.config = configuration;
    }

    public boolean isLcl() {
        return lcl;
    }

    public void setLcl(boolean local) {
        this.lcl = local;
    }

    public String getSecProf() {
        return secProf;
    }

    public void setSecProf(String securityProfile) {
        this.secProf = securityProfile;
    }

    public String getSslSecProf() {
        return sslSecProf;
    }

    public void setSslSecProf(String sslSecurityProfile) {
        this.sslSecProf = sslSecurityProfile;
    }

    public String getTls_key() {
        return tls_key;
    }

    public void setTls_key(String tlsKey) {
        this.tls_key = tlsKey;
    }

    public boolean isInc_Discvry() {
        return inc_Discvry;
    }

    public void setInc_Discvry(boolean includeDiscovery) {
        this.inc_Discvry = includeDiscovery;
    }

    public boolean isInc_dsc_ext() {
        return inc_dsc_ext;
    }

    public void setInc_dsc_ext(boolean includeDiscoveryExtension) {
        this.inc_dsc_ext = includeDiscoveryExtension;
    }

    public String[] getName_id() {
        return name_id;
    }

    public void setName_id(String[] nameID) {
        this.name_id = nameID;
    }

    public String getCus_Disc_url() {
        return cus_Disc_url;
    }

    public void setCus_Disc_url(String customDiscoveryURL) {
        this.cus_Disc_url = customDiscoveryURL;
    }

    public String getCus_Disc_Resp_url() {
        return cus_Disc_Resp_url;
    }

    public void setCus_Disc_Resp_url(String customDiscoveryResponseURL) {
        this.cus_Disc_Resp_url = customDiscoveryResponseURL;
    }



    public String getSslHstNameVerif() {
        return sslHstNameVerif;
    }

    public void setSslHstNameVerif(String sslHostnameVerification) {
        this.sslHstNameVerif = sslHostnameVerification;
    }

    public String getSign_Algo() {
        return sign_Algo;
    }

    public void setSign_Algo(String signingAlgorithm) {
        this.sign_Algo = signingAlgorithm;
    }

}
