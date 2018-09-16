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
package org.citydb.citygml.common.database.xlink;

public class DBXlinkTextureParam implements DBXlink {
	private long id;
	private String gmlId;
	private DBXlinkTextureParamEnum type;

	private boolean isTextureParameterization;
	private String texParamGmlId;
	private String worldToTexture;

	public DBXlinkTextureParam(long id, String gmlId, DBXlinkTextureParamEnum type) {
		this.id = id;
		this.gmlId = gmlId;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGmlId() {
		return gmlId;
	}

	public void setGmlId(String gmlId) {
		this.gmlId = gmlId;
	}

	public DBXlinkTextureParamEnum getType() {
		return type;
	}

	public void setType(DBXlinkTextureParamEnum type) {
		this.type = type;
	}

	public boolean isTextureParameterization() {
		return isTextureParameterization;
	}

	public void setTextureParameterization(boolean isTextureParameterization) {
		this.isTextureParameterization = isTextureParameterization;
	}

	public String getTexParamGmlId() {
		return texParamGmlId;
	}

	public void setTexParamGmlId(String texParamGmlId) {
		this.texParamGmlId = texParamGmlId;
	}

	public String getWorldToTexture() {
		return worldToTexture;
	}

	public void setWorldToTexture(String worldToTexture) {
		this.worldToTexture = worldToTexture;
	}
	
	@Override
	public DBXlinkEnum getXlinkType() {
		return DBXlinkEnum.TEXTUREPARAM;
	}
}
