
import {OrgType} from "./orgType";
import {User} from "./user";
import {DateFormatter} from "@angular/common/src/pipes/deprecated/intl";

export class Organization {

  orgId : number;
  orgName : string;
  orgDescription : string;
  address : string;
  phoneNumber : string;
  numberOfStaff : string;
  additionalInformation : string;
  date: DateFormatter;
  typeOfOrganization? : OrgType;
  director? : User;

}
