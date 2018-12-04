package superchat.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Donation {

		@ApiModelProperty(notes = "The auto-generated ID of the donation")
		private int id;
		@ApiModelProperty(notes = "The streamers id")
		private int streamerId;
		@ApiModelProperty(notes = "The donors id")
		private int donorId;
		@ApiModelProperty(notes = "The value of donation")
		private int eurosponges;		
}
