====

    Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>

    ====================================================================
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    ====================================================================
====

A guide to generating Twitter consumer keys and access tokens is at http://tinyurl.com/2fhebgb

This sample uses the Google App Engine for Java SDK located at 
http://code.google.com/p/googleappengine/downloads/list

Please unzip the above file and modify your maven settings.xml like below before
attempting to run 'mvn -Plive install'

    <profile>
      <id>appengine</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <appengine.sdk.root>/path/to/appengine-java-sdk-1.4.2</appengine.home>
        <appengine.applicationid>yourappid</appengine.applicationid>
      </properties>
    </profile>

    <profile>
      <id>keys</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <test.aws-s3.identity>YOUR_ACCESS_KEY_ID</test.aws-s3.identity>
        <test.aws-s3.credential>YOUR_SECRET_KEY</test.aws-s3.credential>
        <test.cloudfiles-us.identity>YOUR_USER</test.cloudfiles-us.identity>
        <test.cloudfiles-us.credential>YOUR_HEX_KEY</test.cloudfiles-us.credential>
        <test.azureblob.identity>YOUR_ACCOUNT</test.azureblob.identity>
        <test.azureblob.credential>YOUR_BASE64_ENCODED_KEY</test.azureblob.credential>
        <test.twitter.gae-tweetstore.consumer.identity>YOUR_TWITTER_CONSUMER_KEY</test.twitter.gae-tweetstore.consumer.identity>
        <test.twitter.gae-tweetstore.consumer.credential>YOUR_TWITTER_CONSUMER_SECRET</test.twitter.gae-tweetstore.consumer.credential>
        <test.twitter.gae-tweetstore.access.identity>YOUR_TWITTER_ACCESSTOKEN</test.twitter.gae-tweetstore.access.identity>
        <test.twitter.gae-tweetstore.access.credential>YOUR_TWITTER_ACCESSTOKEN_SECRET</test.twitter.gae-tweetstore.access.credential>
      </properties>
    </profile>