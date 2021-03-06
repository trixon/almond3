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
package se.trixon.almond.util.io;

/**
 *
 * @author Patrik Karlström
 */
public class CoordinatePoint {

    private static int DECIMALS_X = 3;
    private static int DECIMALS_Y = 3;
    private static int DECIMALS_Z = 3;

    protected Double mX;
    protected Double mY;
    protected Double mZ;

    public static int getDecimalsX() {
        return DECIMALS_X;
    }

    public static int getDecimalsY() {
        return DECIMALS_Y;
    }

    public static int getDecimalsZ() {
        return DECIMALS_Z;
    }

    public static void setDecimalsX(int decimals) {
        CoordinatePoint.DECIMALS_X = decimals;
    }

    public static void setDecimalsY(int decimals) {
        CoordinatePoint.DECIMALS_Y = decimals;
    }

    public static void setDecimalsZ(int decimals) {
        CoordinatePoint.DECIMALS_Z = decimals;
    }

    public Double getX() {
        return mX;
    }

    public Double getY() {
        return mY;
    }

    public Double getZ() {
        return mZ;
    }

    public void setX(Double x) {
        mX = x;
    }

    public void setY(Double y) {
        mY = y;
    }

    public void setZ(Double z) {
        mZ = z;
    }

}
