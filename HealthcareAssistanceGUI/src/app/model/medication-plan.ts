import {Pill} from './pill';
import {Patient} from './patient';
import {Doctor} from './doctor';

export class MedicationPlan {
  id: number;
  patient: Patient = new Patient();
  startDate: Date;
  endDate: Date;
  pills: Pill[] = [];
  doctor: Doctor = new Doctor();
}
