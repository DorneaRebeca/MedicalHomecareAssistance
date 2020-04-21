import {Patient} from './patient';
import {Caregiver} from './caregiver';

export class Recommendation {
  id: number;
  message : string;
  patient : Patient = new Patient();
  caregiver : Caregiver = new Caregiver();
}
