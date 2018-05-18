package org.gluu.oidc.rpserver.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Document(collection="configurations")
public class Configuration implements Cloneable {
    @Id
    @JsonIgnore
    public String id;
    
    @JsonIgnore
    private String serverUrl;
    
    @JsonIgnore
    private String clientId;
    
    @JsonIgnore
    private String testId;
    
    @JsonProperty(access = Access.WRITE_ONLY)
	private String name;
	
    @Field("userinfo_endpoint")	
	private String userInfoEndpoint;
	
    @Field("request_object_encryption_alg_values_supported")
	private List<String> requestObjectEncAlgValuesSupported;
	
    @Field("token_endpoint")	
	private String tokenEndpoint;
	
    @Field("grant_types_supported")
	private List<String> grantTypesSupported;    
	
    @Field("response_types_supported")
	private List<String> responseTypesSupported;        
	
    @Field("jwks_uri")	
	private String jwksUri;
	
    @Field("claims_parameter_supported")	
	private Boolean claimsParamSupported;    
	
    @Field("userinfo_signing_alg_values_supported")
	private List<String> userInfoSignAlgValuesSupported; 
	
    @Field("subject_types_supported")
	private List<String> subjectTypesSupported; 
	
    @Field("token_endpoint_auth_methods_supported")
	private List<String> tokenEndpointAuthMethodsSupported; 
	
    @Field("acr_values_supported")
	private List<String> acrValuesSupported; 
	
    @Field("response_modes_supported")
	private List<String> responseModesSupported;
	
    @Field("scopes_supported")
	private List<String> scopesSupported;
	
    @Field("id_token_signing_alg_values_supported")
	private List<String> idTokenSignAlgValuesSupported;
	
    @Field("authorization_endpoint")	
	private String authorizationEndpoint;
	
    @Field("request_uri_parameter_supported")	
	private Boolean requestUriParamSupported;
    
    @Field("claim_types_supported")
	private List<String> claimTypesSupported;
	
    @Field("end_session_endpoint")	
	private String endSessionEndpoint;
	
    @Field("request_parameter_supported")	
	private Boolean requestParamSupported;
    
    @Field("request_object_signing_alg_values_supported")
	private List<String> requestObjectSignAlgValuesSupported;
	
    @Field("token_endpoint_auth_signing_alg_values_supported")
	private List<String> tokenEndpointAuthSignAlgValuesSupported;
	
    @Field("request_object_encryption_enc_values_supported")
	private List<String> requestObjectEncValuesSupported;
	
    @Field("claims_supported")
	private List<String> claimsSupported;
	
    @Field("userinfo_encryption_enc_values_supported")
	private List<String> userInfoEncValuesSupported;	
	
    @Field("id_token_encryption_enc_values_supported")
	private List<String> idTokenEncValuesSupported;	
	
    @Field("version")	
	private String version;	
	
    @Field("userinfo_encryption_alg_values_supported")
	private List<String> userInfoEncAlgValuesSupported;	
	
    @Field("id_token_encryption_alg_values_supported")
	private List<String> idTokenEncAlgValuesSupported;	

    @Field("issuer")	
	private String issuer;
    
    @Field("require_request_uri_registration")	
	private Boolean requireRequestUriRegistration;
	
    @Field("registration_endpoint")	
	private String registrationEndpoint;

    public Configuration() { }
    
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserInfoEndpoint() {
		return userInfoEndpoint;
	}

	public void setUserInfoEndpoint(String userInfoEndpoint) {
		this.userInfoEndpoint = userInfoEndpoint;
	}

	public List<String> getRequestObjectEncAlgValuesSupported() {
		return requestObjectEncAlgValuesSupported;
	}

	public void setRequestObjectEncAlgValuesSupported(List<String> requestObjectEncAlgValuesSupported) {
		this.requestObjectEncAlgValuesSupported = requestObjectEncAlgValuesSupported;
	}

	public String getTokenEndpoint() {
		return tokenEndpoint;
	}

	public void setTokenEndpoint(String tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
	}

	public List<String> getGrantTypesSupported() {
		return grantTypesSupported;
	}

	public void setGrantTypesSupported(List<String> grantTypesSupported) {
		this.grantTypesSupported = grantTypesSupported;
	}

	public List<String> getResponseTypesSupported() {
		return responseTypesSupported;
	}

	public void setResponseTypesSupported(List<String> responseTypesSupported) {
		this.responseTypesSupported = responseTypesSupported;
	}

	public String getJwksUri() {
		return jwksUri;
	}

	public void setJwksUri(String jwksUri) {
		this.jwksUri = jwksUri;
	}

	public Boolean getClaimsParamSupported() {
		return claimsParamSupported;
	}

	public void setClaimsParamSupported(Boolean claimsParamSupported) {
		this.claimsParamSupported = claimsParamSupported;
	}

	public List<String> getUserInfoSignAlgValuesSupported() {
		return userInfoSignAlgValuesSupported;
	}

	public void setUserInfoSignAlgValuesSupported(List<String> userInfoSignAlgValuesSupported) {
		this.userInfoSignAlgValuesSupported = userInfoSignAlgValuesSupported;
	}

	public List<String> getSubjectTypesSupported() {
		return subjectTypesSupported;
	}

	public void setSubjectTypesSupported(List<String> subjectTypesSupported) {
		this.subjectTypesSupported = subjectTypesSupported;
	}

	public List<String> getTokenEndpointAuthMethodsSupported() {
		return tokenEndpointAuthMethodsSupported;
	}

	public void setTokenEndpointAuthMethodsSupported(List<String> tokenEndpointAuthMethodsSupported) {
		this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
	}

	public List<String> getAcrValuesSupported() {
		return acrValuesSupported;
	}

	public void setAcrValuesSupported(List<String> acrValuesSupported) {
		this.acrValuesSupported = acrValuesSupported;
	}

	public List<String> getResponseModesSupported() {
		return responseModesSupported;
	}

	public void setResponseModesSupported(List<String> responseModesSupported) {
		this.responseModesSupported = responseModesSupported;
	}

	public List<String> getScopesSupported() {
		return scopesSupported;
	}

	public void setScopesSupported(List<String> scopesSupported) {
		this.scopesSupported = scopesSupported;
	}

	public List<String> getIdTokenSignAlgValuesSupported() {
		return idTokenSignAlgValuesSupported;
	}

	public void setIdTokenSignAlgValuesSupported(List<String> idTokenSignAlgValuesSupported) {
		this.idTokenSignAlgValuesSupported = idTokenSignAlgValuesSupported;
	}

	public String getAuthorizationEndpoint() {
		return authorizationEndpoint;
	}

	public void setAuthorizationEndpoint(String authorizationEndpoint) {
		this.authorizationEndpoint = authorizationEndpoint;
	}

	public Boolean getRequestUriParamSupported() {
		return requestUriParamSupported;
	}

	public void setRequestUriParamSupported(Boolean requestUriParamSupported) {
		this.requestUriParamSupported = requestUriParamSupported;
	}

	public List<String> getClaimTypesSupported() {
		return claimTypesSupported;
	}

	public void setClaimTypesSupported(List<String> claimTypesSupported) {
		this.claimTypesSupported = claimTypesSupported;
	}

	public String getEndSessionEndpoint() {
		return endSessionEndpoint;
	}

	public void setEndSessionEndpoint(String endSessionEndpoint) {
		this.endSessionEndpoint = endSessionEndpoint;
	}

	public Boolean getRequestParamSupported() {
		return requestParamSupported;
	}

	public void setRequestParamSupported(Boolean requestParamSupported) {
		this.requestParamSupported = requestParamSupported;
	}

	public List<String> getRequestObjectSignAlgValuesSupported() {
		return requestObjectSignAlgValuesSupported;
	}

	public void setRequestObjectSignAlgValuesSupported(List<String> requestObjectSignAlgValuesSupported) {
		this.requestObjectSignAlgValuesSupported = requestObjectSignAlgValuesSupported;
	}

	public List<String> getTokenEndpointAuthSignAlgValuesSupported() {
		return tokenEndpointAuthSignAlgValuesSupported;
	}

	public void setTokenEndpointAuthSignAlgValuesSupported(List<String> tokenEndpointAuthSignAlgValuesSupported) {
		this.tokenEndpointAuthSignAlgValuesSupported = tokenEndpointAuthSignAlgValuesSupported;
	}

	public List<String> getRequestObjectEncValuesSupported() {
		return requestObjectEncValuesSupported;
	}

	public void setRequestObjectEncValuesSupported(List<String> requestObjectEncValuesSupported) {
		this.requestObjectEncValuesSupported = requestObjectEncValuesSupported;
	}

	public List<String> getClaimsSupported() {
		return claimsSupported;
	}

	public void setClaimsSupported(List<String> claimsSupported) {
		this.claimsSupported = claimsSupported;
	}

	public List<String> getUserInfoEncValuesSupported() {
		return userInfoEncValuesSupported;
	}

	public void setUserInfoEncValuesSupported(List<String> userInfoEncValuesSupported) {
		this.userInfoEncValuesSupported = userInfoEncValuesSupported;
	}

	public List<String> getIdTokenEncValuesSupported() {
		return idTokenEncValuesSupported;
	}

	public void setIdTokenEncValuesSupported(List<String> idTokenEncValuesSupported) {
		this.idTokenEncValuesSupported = idTokenEncValuesSupported;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<String> getUserInfoEncAlgValuesSupported() {
		return userInfoEncAlgValuesSupported;
	}

	public void setUserInfoEncAlgValuesSupported(List<String> userInfoEncAlgValuesSupported) {
		this.userInfoEncAlgValuesSupported = userInfoEncAlgValuesSupported;
	}

	public List<String> getIdTokenEncAlgValuesSupported() {
		return idTokenEncAlgValuesSupported;
	}

	public void setIdTokenEncAlgValuesSupported(List<String> idTokenEncAlgValuesSupported) {
		this.idTokenEncAlgValuesSupported = idTokenEncAlgValuesSupported;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Boolean getRequireRequestUriRegistration() {
		return requireRequestUriRegistration;
	}

	public void setRequireRequestUriRegistration(Boolean requireRequestUriRegistration) {
		this.requireRequestUriRegistration = requireRequestUriRegistration;
	}

	public String getRegistrationEndpoint() {
		return registrationEndpoint;
	}

	public void setRegistrationEndpoint(String registrationEndpoint) {
		this.registrationEndpoint = registrationEndpoint;
	}	
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	private static final String SERVER_URL_PLACEHOLDER = "\\$\\{SERVER_URL\\}";
	private static final String CLIENT_ID_PLACEHOLDER = "\\$\\{CLIENT_ID\\}";
	private static final String TEST_ID_PLACEHOLDER = "\\$\\{TEST_ID\\}";
	
	// Overriding clone() method of Object class
	@Override
	public Object clone() throws CloneNotSupportedException {
		this.userInfoEndpoint = this.userInfoEndpoint.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());
		this.userInfoEndpoint = this.userInfoEndpoint.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.userInfoEndpoint = this.userInfoEndpoint.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		this.tokenEndpoint = this.tokenEndpoint.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());
		this.tokenEndpoint = this.tokenEndpoint.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.tokenEndpoint = this.tokenEndpoint.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		this.jwksUri = this.jwksUri.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());

		this.authorizationEndpoint = this.authorizationEndpoint.replaceFirst(SERVER_URL_PLACEHOLDER,
				this.getServerUrl());
		this.authorizationEndpoint = this.authorizationEndpoint.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.authorizationEndpoint = this.authorizationEndpoint.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		this.endSessionEndpoint = this.endSessionEndpoint.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());
		this.endSessionEndpoint = this.endSessionEndpoint.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.endSessionEndpoint = this.endSessionEndpoint.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		this.issuer = this.issuer.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());
		this.issuer = this.issuer.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.issuer = this.issuer.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		this.registrationEndpoint = this.registrationEndpoint.replaceFirst(SERVER_URL_PLACEHOLDER, this.getServerUrl());
		this.registrationEndpoint = this.registrationEndpoint.replaceFirst(CLIENT_ID_PLACEHOLDER, this.getClientId());
		this.registrationEndpoint = this.registrationEndpoint.replaceFirst(TEST_ID_PLACEHOLDER, this.getTestId());

		return (Configuration) super.clone();
	}	
}
