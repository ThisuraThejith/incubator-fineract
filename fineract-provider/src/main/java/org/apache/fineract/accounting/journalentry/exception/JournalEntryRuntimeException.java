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
package org.apache.fineract.accounting.journalentry.exception;


import org.apache.fineract.infrastructure.core.exception.AbstractPlatformDomainRuleException;

public class JournalEntryRuntimeException extends AbstractPlatformDomainRuleException {

    public final static String INVALID_CREDITS = "NO_OFFICE_WITH_ID";
    public final static String INVALID_DEBITS = "INVALID_DEBITS";
    /*** enum of reasons for journal runtime exception **/
    public static enum GL_JOURNAL_ENTRY_RUNTIME_EXCEPTION_REASON {
        INVALID_CREDITS, INVALID_DEBITS;

        public String errorMessage() {
            if (name().toString().equalsIgnoreCase(JournalEntryRuntimeException.INVALID_CREDITS)) {
                return "Invalid Credits.";
            } else if (name().toString().equalsIgnoreCase(JournalEntryRuntimeException.INVALID_DEBITS)) {
                return "Invalid Debits";
            }
            return name().toString();
        }

        public String errorCode() {
            if (name().toString().equalsIgnoreCase(JournalEntryRuntimeException.INVALID_CREDITS)) {
                return "error.msg.glJournalEntry.invalid.credits";
            } else if (name().toString().equalsIgnoreCase(JournalEntryRuntimeException.INVALID_DEBITS)) {
                return "error.msg.glJournalEntry.invalid.debits";
            }
            return name().toString();
        }
    }

    public JournalEntryRuntimeException(final GL_JOURNAL_ENTRY_RUNTIME_EXCEPTION_REASON reason) {
        super(reason.errorCode(), reason.errorMessage());
    }
}
