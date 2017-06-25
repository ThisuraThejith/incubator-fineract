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
package org.apache.fineract.infrastructure.campaigns.sms.exception;

import org.apache.fineract.infrastructure.core.exception.AbstractPlatformDomainRuleException;

public class SmsRuntimeException extends AbstractPlatformDomainRuleException {
    public final static String NO_OFFICE_WITH_ID = "NO_OFFICE_WITH_ID";
    public final static String NO_OFFICE_ID = "NO_OFFICE_ID";
    /*** enum of reasons for sms runtime exception **/
    public static enum SMS_RUNTIME_EXCEPTION_REASON {
        NO_OFFICE_WITH_ID, NO_OFFICE_ID ;

        public String errorMessage() {
            if (name().toString().equalsIgnoreCase(SmsRuntimeException.NO_OFFICE_WITH_ID)) {
                return "Office not found for the id";
            } else if (name().toString().equalsIgnoreCase(SmsRuntimeException.NO_OFFICE_ID)) {
                return "Office Id attribute is not found";
            }
            return name().toString();
        }

        public String errorCode() {
            if (name().toString().equalsIgnoreCase(SmsRuntimeException.NO_OFFICE_WITH_ID)) {
                return "error.msg.no.office";
            } else if (name().toString().equalsIgnoreCase(SmsRuntimeException.NO_OFFICE_ID)) {
                return "error.msg.no.id.attribute";
            }
            return name().toString();
        }
    }

    public SmsRuntimeException(final SMS_RUNTIME_EXCEPTION_REASON reason) {
        super(reason.errorCode(), reason.errorMessage());
    }
}
