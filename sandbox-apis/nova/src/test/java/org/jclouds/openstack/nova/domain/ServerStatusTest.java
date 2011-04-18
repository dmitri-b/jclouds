/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
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

package org.jclouds.openstack.nova.domain;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Tests behavior of {@code CreateImageBinder}
 *
 * @author Adrian Cole
 */
@Test(groups = "unit")
public class ServerStatusTest {

   @Test
   public void testAllKnownStatusesIsRecognized() {
      List<String> knownStatuses = Arrays.asList(
            "ACTIVE", "BUILD", "REBUILD", "SUSPENDED", "QUEUE_RESIZE",
            "PREP_RESIZE", "RESIZE", "VERIFY_RESIZE",
            "PASSWORD", "RESCUE", "REBOOT",
            "HARD_REBOOT", "DELETE_IP", "UNKNOWN");
      List<String> allStatuses = Lists.newArrayList(knownStatuses);
      allStatuses.add("UNRECOGNIZED");
      for (String status : knownStatuses) {
         assertFalse(ServerStatus.fromValue(status).equals(ServerStatus.UNRECOGNIZED));
      }

      assertEquals(Arrays.asList(ServerStatus.values()), allStatuses);
   }

}

