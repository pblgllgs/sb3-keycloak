package com.pblgllgs.remoteuserstorageprovider;
/*
 *
 * @author pblgl
 * Created on 07-02-2024
 *
 */

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class RemoteUserStorageProviderFactory implements UserStorageProviderFactory<RemoteUserStorageProvider> {

    public static final String PROVIDER_NAME = "my-remote-mysql-user-storage-provider";
    @Override
    public RemoteUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new RemoteUserStorageProvider(
                keycloakSession,
                componentModel,
                buildHttpClient("http://localhost:8099")
        );
    }

    @Override
    public String getId() {
        return null;
    }

    private UserApiService buildHttpClient(String uri){
        ResteasyClient build = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = build.target(uri);

        return target.proxyBuilder(UserApiService.class).classloader(UserApiService.class.getClassLoader()).build();
    }
}
