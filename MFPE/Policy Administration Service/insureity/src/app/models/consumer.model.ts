export interface ConsumerDto {
  firstName: string;
  lastName: string;
  dob: string;
  email: string;
  pan: string;
  businessName: string;
  businessType: string;
  businessAge: number;
  capitalInvested: number;
  businessTurnover: number;
  totalEmployees: number;
  validity: string;
  agentName: string;
  agentId: number;
}
export class Consumer {
  public firstName: string;
  public lastName: string;
  public dob: string;
  public email: string;
  public pan: string;
  public businessName: string;
  public businessType: string;
  public businessAge: number;
  public capitalInvested: number;
  public businessTurnover: number;
  public totalEmployees: number;
  public validity: string;
  public agentName: string;
  public agentId!: number;

  constructor(
    firstName: string,
    lastName: string,
    dob: string,
    email: string,
    pan: string,
    businessName: string,
    businessType: string,
    businessAge: number,
    capitalInvested: number,
    businessTurnover: number,
    totalEmployees: number,
    validity: string,
    agentName: string,
    agentId: number
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
    this.pan = pan;
    this.businessName = businessName;
    this.businessType = businessType;
    this.businessAge = businessAge;
    this.capitalInvested = capitalInvested;
    this.businessTurnover = businessTurnover;
    this.totalEmployees = totalEmployees;
    this.validity = validity;
    this.agentName = agentName;
    this.agentId = agentId;
  }
}
