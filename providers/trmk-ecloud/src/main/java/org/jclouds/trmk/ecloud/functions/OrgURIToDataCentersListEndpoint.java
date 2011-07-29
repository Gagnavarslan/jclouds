/**
 *
 * Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.trmk.ecloud.functions;

import java.net.URI;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jclouds.trmk.ecloud.domain.ECloudOrg;
import org.jclouds.trmk.vcloud_0_8.domain.Org;
import org.jclouds.trmk.vcloud_0_8.domain.ReferenceType;
import org.jclouds.trmk.vcloud_0_8.functions.OrgURIToEndpoint;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

/**
 * 
 * @author Adrian Cole
 */
@Singleton
public class OrgURIToDataCentersListEndpoint extends OrgURIToEndpoint implements Function<Object, URI> {
   @Inject
   public OrgURIToDataCentersListEndpoint(Supplier<Map<String, ? extends Org>> orgMap,
         @org.jclouds.trmk.vcloud_0_8.endpoints.Org ReferenceType defaultUri) {
      super(orgMap, defaultUri);
   }

   public URI getUriFromOrg(Org org) {
      return ECloudOrg.class.cast(org).getDataCenters().getHref();
   }

}