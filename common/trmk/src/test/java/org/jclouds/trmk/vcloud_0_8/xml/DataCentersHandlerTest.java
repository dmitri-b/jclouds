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
package org.jclouds.trmk.vcloud_0_8.xml;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.util.Set;

import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.trmk.vcloud_0_8.domain.DataCenter;
import org.jclouds.trmk.vcloud_0_8.xml.DataCentersHandler;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;

/**
 * Tests behavior of {@code DataCentersHandler}
 * 
 * @author Adrian Cole
 */
// NOTE:without testName, this will not call @Before* and fail w/NPE during
// surefire
@Test(groups = "unit", testName = "DataCentersHandlerTest")
public class DataCentersHandlerTest extends BaseHandlerTest {

   public void test() {
      InputStream is = getClass().getResourceAsStream("/datacenters.xml");

      Set<DataCenter> result = factory.create(injector.getInstance(DataCentersHandler.class)).parse(is);

      ImmutableSet<DataCenter> expects = ImmutableSet.<DataCenter>of(DataCenter.builder().id("1").name("Terremark - Miami").code("MIA").build(),
            DataCenter.builder().id("3670").name("Terremark - Culpeper").code("CUA").build());
      assertEquals(result.toString(), expects.toString());
   }

}
