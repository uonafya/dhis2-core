package org.hisp.dhis.hibernate.encryption;

/*
 * Copyright (c) 2004-2015, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.google.api.client.util.Maps;
import org.jasypt.encryption.pbe.PBEStringEncryptor;

import java.util.Map;

/**
 * Singleton container for all named Hibernate Encryptors.
 * {@link org.hisp.dhis.hibernate.encryption.type.EncryptedStringUserType EncryptedStringUserType}
 * depends on this singleton to access the appropriate encryptors.
 *
 * @author Halvdan Hoem Grelland
 */
public enum HibernateEncryptors
{
    INSTANCE;

    public static HibernateEncryptors getInstance()
    {
        return INSTANCE;
    }

    private Map<String, PBEStringEncryptor> encryptors = Maps.newHashMap();

    public void setNamedEncryptors( Map<String, PBEStringEncryptor> encryptors )
    {
        this.encryptors.putAll( encryptors );
    }

    public PBEStringEncryptor getNamedEncryptor( String name )
    {
        return encryptors.get( name );
    }
}