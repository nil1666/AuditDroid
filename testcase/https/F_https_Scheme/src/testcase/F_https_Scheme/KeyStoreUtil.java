/*
 * Copyright (C) 2012-2014 Japan Smartphone Security Association
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package testcase.F_https_Scheme;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class KeyStoreUtil {
	public static KeyStore getEmptyKeyStore() throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance("BKS");
		ks.load(null);
		return ks;
	}

	public static void loadAndroidCAStore(KeyStore ks) throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException {
		KeyStore aks = KeyStore.getInstance("AndroidCAStore");
		aks.load(null);
		Enumeration<String> aliases = aks.aliases();
		while (aliases.hasMoreElements()) {
			String alias = aliases.nextElement();
			Certificate cert = aks.getCertificate(alias);
			ks.setCertificateEntry(alias, cert);
		}
	}

	public static void loadX509Certificate(KeyStore ks, InputStream is) throws CertificateException,
			KeyStoreException {
		try {
			CertificateFactory factory = CertificateFactory.getInstance("X509");
			X509Certificate x509 = (X509Certificate) factory.generateCertificate(is);
			String alias = x509.getSubjectDN().getName();
			ks.setCertificateEntry(alias, x509);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}
}
