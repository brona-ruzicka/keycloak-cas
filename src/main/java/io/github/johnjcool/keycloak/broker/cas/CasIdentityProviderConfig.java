package io.github.johnjcool.keycloak.broker.cas;

import java.io.Serial;
import org.keycloak.models.IdentityProviderModel;

public class CasIdentityProviderConfig extends IdentityProviderModel {

  @Serial private static final long serialVersionUID = 1L;

  private static final String DEFAULT_CAS_LOGIN_SUFFIX = "login";
  private static final String DEFAULT_CAS_LOGOUT_SUFFIX = "logout";
  private static final String CAS_SERVICE_VALIDATE_SUFFIX = "serviceValidate";

  public CasIdentityProviderConfig() {
    super();
  }

  public CasIdentityProviderConfig(final IdentityProviderModel model) {
    super(model);
  }

  public void setCasServerUrlPrefix(final String casServerUrlPrefix) {
    getConfig().put("casServerUrlPrefix", casServerUrlPrefix);
  }

  public String getCasServerUrlPrefix() {
    return getConfig().get("casServerUrlPrefix");
  }

  public void setProxyUri(final String proxyUri) {
    getConfig().put("proxyUri", proxyUri);
  }

  public String getProxyUri() {
    String value = getConfig().get("proxyUri");
    return value != "" ? value : null;
  }

  public void setGateway(final boolean gateway) {
    getConfig().put("gateway", String.valueOf(gateway));
  }

  public boolean isGateway() {
    return Boolean.parseBoolean(getConfig().get("gateway"));
  }

  public void setRenew(final boolean renew) {
    getConfig().put("renew", String.valueOf(renew));
  }

  public boolean isRenew() {
    return Boolean.parseBoolean(getConfig().get("renew"));
  }

  public String getCasServerLoginUrl() {
    return String.format("%s/%s", getConfig().get("casServerUrlPrefix"), DEFAULT_CAS_LOGIN_SUFFIX);
  }

  public String getCasServerLogoutUrl() {
    return String.format("%s/%s", getConfig().get("casServerUrlPrefix"), DEFAULT_CAS_LOGOUT_SUFFIX);
  }

  public String getCasServiceValidateUrl() {
    return String.format("%s/%s", getConfig().get("casServerUrlPrefix"), CAS_SERVICE_VALIDATE_SUFFIX);
  }
}
