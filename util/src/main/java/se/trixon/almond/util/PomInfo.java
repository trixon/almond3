/*
 * Copyright 2019 Patrik Karlström.
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
package se.trixon.almond.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrik Karlström
 */
public class PomInfo {

    private String mArtifactId = "NOT SET";
    private String mGroupId = "NOT SET";
    private String mVersion = "NOT SET";

    public PomInfo(Class c, String groupId, String artifactId) {
        InputStream inputStream = c.getResourceAsStream(String.format("/META-INF/maven/%s/%s/pom.properties", groupId, artifactId));
        Properties p = new Properties();

        if (inputStream != null) {
            try {
                p.load(inputStream);
                mArtifactId = p.getProperty("artifactId");
                mGroupId = p.getProperty("groupId");
                mVersion = p.getProperty("version");
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(SystemHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getArtifactId() {
        return mArtifactId;
    }

    public String getGroupId() {
        return mGroupId;
    }

    public String getVersion() {
        return mVersion;
    }

//    public void load(Properties p) {
//        mArtifactId = p.getProperty("artifactId");
//        mGroupId = p.getProperty("groupId");
//        mVersion = p.getProperty("version");
//    }
//
//    public static PomInfo getPomInfo(Class c, String groupId, String artifactId) {
//        InputStream inputStream = c.getResourceAsStream(String.format("/META-INF/maven/%s/%s/pom.properties", groupId, artifactId));
//        Properties p = new Properties();
//        PomInfo pomInfo = new PomInfo();
//        if (inputStream != null) {
//            try {
//
//                p.load(inputStream);
//                return new PomInfo(p);
//            } catch (IOException | NullPointerException ex) {
//                Logger.getLogger(SystemHelper.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return pomInfo;
//    }
}
