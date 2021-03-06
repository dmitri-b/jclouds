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
package org.jclouds.trmk.ecloud.compute.config;

import static org.jclouds.compute.domain.OsFamily.UBUNTU;

import org.jclouds.compute.domain.TemplateBuilder;
import org.jclouds.trmk.ecloud.compute.functions.TerremarkECloudParseOsFromVAppTemplateName;
import org.jclouds.trmk.ecloud.suppliers.TerremarkECloudInternetServiceAndPublicIpAddressSupplier;
import org.jclouds.trmk.vcloud_0_8.compute.config.TerremarkVCloudComputeServiceContextModule;
import org.jclouds.trmk.vcloud_0_8.compute.functions.ParseOsFromVAppTemplateName;
import org.jclouds.trmk.vcloud_0_8.suppliers.InternetServiceAndPublicIpAddressSupplier;

import com.google.inject.Injector;

/**
 * @author Adrian Cole
 */
public class TerremarkECloudComputeServiceContextModule extends TerremarkVCloudComputeServiceContextModule {

   @Override
   protected void configure() {
      bind(InternetServiceAndPublicIpAddressSupplier.class).to(
               TerremarkECloudInternetServiceAndPublicIpAddressSupplier.class);
      bind(ParseOsFromVAppTemplateName.class).to(TerremarkECloudParseOsFromVAppTemplateName.class);
      super.configure();
   }
   
   @Override
   protected TemplateBuilder provideTemplate(Injector injector, TemplateBuilder template) {
      return template.osFamily(UBUNTU).osVersionMatches("1[10].[10][04]").os64Bit(true);
   }

}
