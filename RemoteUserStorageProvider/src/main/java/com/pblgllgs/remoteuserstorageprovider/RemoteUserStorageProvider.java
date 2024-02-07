package com.pblgllgs.remoteuserstorageprovider;
/*
 *
 * @author pblgl
 * Created on 07-02-2024
 *
 */

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.UserCredentialStore;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.adapter.AbstractUserAdapter;
import org.keycloak.storage.user.UserLookupProvider;

public class RemoteUserStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator {

    private KeycloakSession keycloakSession;
    private ComponentModel componentModel;
    private UserApiService userApiService;

    public RemoteUserStorageProvider(KeycloakSession keycloakSession, ComponentModel componentModel, UserApiService userApiService) {
        this.keycloakSession = keycloakSession;
        this.componentModel = componentModel;
        this.userApiService = userApiService;
    }

    @Override
    public void close() {

    }

    @Override
    public UserModel getUserById(String s, RealmModel realmModel) {
        return null;
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realmModel) {

        UserModel modelReturn = null;

        User userDetail = userApiService.getUserDetail(username);
        if (userDetail != null){
            modelReturn = createUsrModel(username, realmModel);
        }
        return modelReturn;
    }

    private UserModel createUsrModel(String username, RealmModel realmModel) {
        return new AbstractUserAdapter(keycloakSession, realmModel,componentModel){
            @Override
            public String getUsername(){
                return username;
            }
        };
    }

    @Override
    public UserModel getUserByEmail(String s, RealmModel realmModel) {
        return null;
    }

    @Override
    public boolean supportsCredentialType(String s) {
        return PasswordCredentialModel.TYPE.equals(s);
    }

    @Override
    public boolean isConfiguredFor(RealmModel realmModel, UserModel userModel, String s) {
        if (!supportsCredentialType(s)){
            return false;
        }
        return !getCredentialStore().getStoredCredentialsByType(realmModel,userModel,s).isEmpty();
    }

    private UserCredentialStore getCredentialStore() {
        return keycloakSession.userCredentialManager();
    }

    @Override
    public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        VerifyPasswordResponse verifyPasswordResponse = userApiService.verifyUserPassword(
                userModel.getUsername(),
                credentialInput.getChallengeResponse()
        );
        if (verifyPasswordResponse == null) {
            return false;
        }
        return verifyPasswordResponse.getResult();
    }
}
