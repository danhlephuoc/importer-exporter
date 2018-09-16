/*
 * 3D City Database - The Open Source CityGML Database
 * http://www.3dcitydb.org/
 * 
 * Copyright 2013 - 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The 3D City Database is jointly developed with the following
 * cooperation partners:
 * 
 * virtualcitySYSTEMS GmbH, Berlin <http://www.virtualcitysystems.de/>
 * M.O.S.S. Computer Grafik Systeme GmbH, Taufkirchen <http://www.moss.de/>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citydb.citygml.common.database.cache.model;

public enum CacheTableModel {
	// provide a unique id for the tmp table
	// that does not extend 6 chars!
	GMLID_FEATURE("IDF"),
	GMLID_GEOMETRY("IDG"),
	SURFACE_GEOMETRY("SG"),
	SOLID_GEOMETRY("SOG"),
	BASIC("BA"),
	LINEAR_RING("LR"),
	TEXTURE_COORD_LIST("TC"),
	TEXTUREPARAM("TP"),
	TEXTUREASSOCIATION("TA"),
	TEXTUREASSOCIATION_TARGET("TAT"),
	TEXTURE_FILE_ID("IDT"),
	TEXTURE_FILE("TF"),
	SURFACE_DATA_TO_TEX_IMAGE("STT"),
	LIBRARY_OBJECT("LO"),
	DEPRECATED_MATERIAL("DP"),
	GROUP_TO_CITYOBJECT("GTC"),
	GLOBAL_APPEARANCE("GA");

	private final String value;

	CacheTableModel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
