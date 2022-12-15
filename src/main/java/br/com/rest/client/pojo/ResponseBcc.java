package br.com.rest.client.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseBcc{

	@JsonProperty("@odata.context")
	private String odataContext;

	@JsonProperty("value")
	private List<ValueItem> value;


}