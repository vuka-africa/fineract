/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.integrationtests.common;

import com.google.gson.Gson;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;

public final class PasswordPreferencesHelper {

    private PasswordPreferencesHelper() {

    }

    private static final String PASSWORD_PREFERENCES_URL = "/fineract-provider/api/v1/passwordpreferences";

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static Object updatePasswordPreferences(final RequestSpecification requestSpec, final ResponseSpecification responseSpec,
            String validationPolicyId) {
        final String UPDATE_PASSWORD_PREFERENCES_URL = PASSWORD_PREFERENCES_URL + "?" + Utils.TENANT_IDENTIFIER;
        // system.out.println("---------------------------------UPDATE PASSWORD
        // PREFERENCE---------------------------------------------");
        return Utils.performServerPut(requestSpec, responseSpec, UPDATE_PASSWORD_PREFERENCES_URL,
                updatePreferencesAsJson(validationPolicyId), "");
    }

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static Object updateWithInvalidValidationPolicyId(final RequestSpecification requestSpec,
            final ResponseSpecification responseSpec, String invalidValidationPolicyId, String jsonAttributeToGetback) {
        final String UPDATE_PASSWORD_PREFERENCES_URL = PASSWORD_PREFERENCES_URL + "?" + Utils.TENANT_IDENTIFIER;
        // system.out
        // .println("---------------------------------UPDATE PASSWORD
        // PREFERENCES WITH INVALID
        // ID-----------------------------------------");
        return Utils.performServerPut(requestSpec, responseSpec, UPDATE_PASSWORD_PREFERENCES_URL,
                updatePreferencesWithInvalidId(invalidValidationPolicyId), jsonAttributeToGetback);
    }

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static String updatePreferencesAsJson(String validationPolicyId) {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("validationPolicyId", validationPolicyId);
        return new Gson().toJson(map);
    }

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static String updatePreferencesWithInvalidId(String invalidValidationPolicyId) {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("validationPolicyId", invalidValidationPolicyId);
        return new Gson().toJson(map);
    }

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static int getActivePasswordPreference(final RequestSpecification requestSpec, final ResponseSpecification responseSpec) {
        return Utils.performServerGet(requestSpec, responseSpec, PASSWORD_PREFERENCES_URL + "?" + Utils.TENANT_IDENTIFIER, "id");
    }

    // TODO: Rewrite to use fineract-client instead!
    // Example: org.apache.fineract.integrationtests.common.loans.LoanTransactionHelper.disburseLoan(java.lang.Long,
    // org.apache.fineract.client.models.PostLoansLoanIdRequest)
    @Deprecated(forRemoval = true)
    public static HashMap<String, Object> getAllPreferences(final RequestSpecification requestSpec,
            final ResponseSpecification responseSpec) {

        return Utils.performServerGet(requestSpec, responseSpec, PASSWORD_PREFERENCES_URL + "/template" + "?" + Utils.TENANT_IDENTIFIER,
                "");

    }

}
