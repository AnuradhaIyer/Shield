
package edu.sjsu.dev.portal;

import java.net.MalformedURLException;
import java.net.URL;

import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.springframework.security.saml.metadata.MetadataManager;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class MDVal implements Validator {

    MetadataManager mgr;

    public MDVal(MetadataManager manager) {
        this.mgr = manager;
    }

    public boolean supports(Class<?> clazz) {
        return clazz.equals(MDFrm.class);
    }

    public void validate(Object target, Errors errors) {

        MDFrm metadata = (MDFrm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "entityId", "required", "Entity id required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "baseURL", "required", "please enter Base URL.");

        if (metadata.getSecProf() == null) {
            errors.rejectValue("securityProfile", null, "Specify Security profile.");
        } else if (!"pkix".equalsIgnoreCase(metadata.getSecProf()) && !"metaiop".equals(metadata.getSecProf())) {
            errors.rejectValue("securityProfile", null, "Unsupported Selected value.");
        }

        if (metadata.getSslSecProf() == null) {
            errors.rejectValue("sslSecurityProfile", null, "Specify SSL/TLS Security profile.");
        } else if (!"pkix".equalsIgnoreCase(metadata.getSslSecProf()) && !"metaiop".equals(metadata.getSslSecProf())) {
            errors.rejectValue("sslSecurityProfile", null, "Value currently selected is not supported.");
        }

        if (metadata.isInc_Discvry() && metadata.getCus_Disc_url() != null && metadata.getCus_Disc_url().length() > 0) {
            try {
                new URL(metadata.getCus_Disc_url());
            } catch (MalformedURLException e) {
                errors.rejectValue("customDiscoveryURL", null, "Not a valid URL.");
            }
        }

        if (metadata.isInc_Discvry() && metadata.getCus_Disc_Resp_url() != null && metadata.getCus_Disc_Resp_url().length() > 0) {
            try {
                new URL(metadata.getCus_Disc_Resp_url());
            } catch (MalformedURLException e) {
                errors.rejectValue("customDiscoveryResponseURL", null, "Not a valid URL.");
            }
        }

//        // Bindings
//        if (metadata.getSingleSignOn_Bindings() == null || metadata.getSingleSignOn_Bindings().length == 0) {
//            errors.rejectValue("ssoBindings", null, "Specify min 1 binding.");
//        }
//
//        // Default binding
//        if (metadata.getSingleSignOn_Default_Binding() != null && metadata.getSingleSignOn_Bindings() != null) {
//            boolean found = false;
//            for (String binding : metadata.getSingleSignOn_Bindings()) {
//                if (binding.equals(metadata.getSingleSignOn_Default_Binding())) {
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                errors.rejectValue("ssoDefaultBinding", null, "Select Default binding.");
//            }
//        }

        if (metadata.getName_id() == null || metadata.getName_id().length == 0) {
            errors.rejectValue("nameID", null, "Selct min 1 NameID.");
        }

        try {
            if (!errors.hasErrors() && metadata.isStore()) {
                EntityDescriptor entityDescriptor = mgr.getEntityDescriptor(metadata.getEntityId());
                if (entityDescriptor != null) {
                    errors.rejectValue("entityId", null, "Entity-ID already in used.");
                }
                String idForAlias = mgr.getEntityIdForAlias(metadata.getAlias());
                if (idForAlias != null) {
                    errors.rejectValue("alias", null, "Alias already in use.");
                }
            }
        } catch (MetadataProviderException e) {
            throw new RuntimeException("Error in loading alias data", e);
        }

    }

}