/*
 * Copyright 2024 OmniOne.
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

package org.omnione.did.data.model.vc;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 */

@Getter
@Setter
public class CredentialSchema extends DataObject {

	/**	 
	 * VC Schema URL
	 */
	@SerializedName("id")
	@Expose @NotEmpty
	private String id;

	/**	 
	 * VC Schema format type
	 * CredentialSchemaType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty
	private String type;
	
	// TODO Create it by inheriting it from the profile package...
	// Issue Profile, Verify Profile
	/**
	 * Schema string encoded in multibase
	 */
	@SerializedName("value")
	@Expose
	private String value;
	
    @SerializedName("presentAll")
    @Expose
    private Boolean presentAll;
		
	// Verify Profile
	/**
	 * List of claim codes to show to user
	 */
	@SerializedName("displayClaims")
	@Expose
	private List<String> displayClaims;
	
	// Verify Profile
	/**
	 * 	List of claim codes that must be submitted
	 */
	@SerializedName("requiredClaims")
	@Expose
	private List<String> requiredClaims;
	
	// Verify Profile
	/**
	 * did list of allowed issuers
	 */
	@SerializedName("allowedIssuers")
	@Expose
	private List<String> allowedIssuers;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		CredentialSchema data = gson.fromJson(val, CredentialSchema.class);
		
		id = data.id;
		type = data.type;
		value = data.value;
		displayClaims = data.displayClaims;
		requiredClaims = data.requiredClaims;
		allowedIssuers = data.allowedIssuers;
		presentAll = data.presentAll;
	}

}
