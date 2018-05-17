package org.gluu.oidc.rpserver.controller.rp;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WellknownConfigController {
    @RequestMapping(path = "{client_id}/{test_id}/.well-known/openid-configuration", method = RequestMethod.GET)
    public @ResponseBody String deliverConfiguration(
    		@PathVariable("client_id") String clientId,
    		@PathVariable("test_id") String testId,
    		HttpServletResponse response) {
    	System.out.println("Inside deliverConfiguration()");
    	System.out.println("clientId=" + clientId);
    	System.out.println("testId=" + testId);

    	return "{\"userinfo_endpoint\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code/userinfo\", \"request_object_encryption_alg_values_supported\": [\"RSA1_5\", \"RSA-OAEP\", \"RSA-OAEP-256\", \"A128KW\", \"A192KW\", \"A256KW\", \"ECDH-ES\", \"ECDH-ES+A128KW\", \"ECDH-ES+A192KW\", \"ECDH-ES+A256KW\"], \"token_endpoint\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code/token\", \"grant_types_supported\": [\"authorization_code\", \"implicit\", \"urn:ietf:params:oauth:grant-type:jwt-bearer\", \"refresh_token\"], \"response_types_supported\": [\"code\"], \"jwks_uri\": \"https://vnik2.gluu.info:8080/static/jwks_1qAJtD9rhXEa0P7T.json\", \"claims_parameter_supported\": true, \"userinfo_signing_alg_values_supported\": [\"RS256\", \"RS384\", \"RS512\", \"ES256\", \"ES384\", \"ES512\", \"HS256\", \"HS384\", \"HS512\", \"PS256\", \"PS384\", \"PS512\", \"none\"], \"subject_types_supported\": [\"public\", \"pairwise\"], \"token_endpoint_auth_methods_supported\": [\"client_secret_post\", \"client_secret_basic\", \"client_secret_jwt\", \"private_key_jwt\"], \"acr_values_supported\": [\"PASSWORD\"], \"response_modes_supported\": [\"query\", \"fragment\", \"form_post\"], \"scopes_supported\": [\"offline_access\", \"address\", \"profile\", \"openid\", \"phone\", \"email\", \"openid\"], \"id_token_signing_alg_values_supported\": [\"RS256\", \"RS384\", \"RS512\", \"ES256\", \"ES384\", \"ES512\", \"HS256\", \"HS384\", \"HS512\", \"PS256\", \"PS384\", \"PS512\", \"none\"], \"authorization_endpoint\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code/authorization\", \"request_uri_parameter_supported\": true, \"claim_types_supported\": [\"normal\", \"aggregated\", \"distributed\"], \"end_session_endpoint\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code/end_session\", \"request_parameter_supported\": true, \"request_object_signing_alg_values_supported\": [\"RS256\", \"RS384\", \"RS512\", \"ES256\", \"ES384\", \"ES512\", \"HS256\", \"HS384\", \"HS512\", \"PS256\", \"PS384\", \"PS512\", \"none\"], \"token_endpoint_auth_signing_alg_values_supported\": [\"RS256\", \"RS384\", \"RS512\", \"ES256\", \"ES384\", \"ES512\", \"HS256\", \"HS384\", \"HS512\", \"PS256\", \"PS384\", \"PS512\"], \"request_object_encryption_enc_values_supported\": [\"A128CBC-HS256\", \"A192CBC-HS384\", \"A256CBC-HS512\", \"A128GCM\", \"A192GCM\", \"A256GCM\"], \"claims_supported\": [\"birthdate\", \"sub\", \"email_verified\", \"name\", \"website\", \"middle_name\", \"gender\", \"email\", \"family_name\", \"given_name\", \"address\", \"profile\", \"picture\", \"zoneinfo\", \"locale\", \"updated_at\", \"preferred_username\", \"phone_number\", \"nickname\", \"phone_number_verified\"], \"userinfo_encryption_enc_values_supported\": [\"A128CBC-HS256\", \"A192CBC-HS384\", \"A256CBC-HS512\", \"A128GCM\", \"A192GCM\", \"A256GCM\"], \"id_token_encryption_enc_values_supported\": [\"A128CBC-HS256\", \"A192CBC-HS384\", \"A256CBC-HS512\", \"A128GCM\", \"A192GCM\", \"A256GCM\"], \"version\": \"3.0\", \"userinfo_encryption_alg_values_supported\": [\"RSA1_5\", \"RSA-OAEP\", \"RSA-OAEP-256\", \"A128KW\", \"A192KW\", \"A256KW\", \"ECDH-ES\", \"ECDH-ES+A128KW\", \"ECDH-ES+A192KW\", \"ECDH-ES+A256KW\"], \"id_token_encryption_alg_values_supported\": [\"RSA1_5\", \"RSA-OAEP\", \"RSA-OAEP-256\", \"A128KW\", \"A192KW\", \"A256KW\", \"ECDH-ES\", \"ECDH-ES+A128KW\", \"ECDH-ES+A192KW\", \"ECDH-ES+A256KW\"], \"issuer\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code\", \"require_request_uri_registration\": true, \"registration_endpoint\": \"https://vnik2.gluu.info:8080/gluu/rp-response_type-code/registration\"}";
    }
}
