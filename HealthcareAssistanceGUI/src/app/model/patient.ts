import {Caregiver} from './caregiver';
import {MedicationPlan} from './medication-plan';

export class Patient {
  id: number;
  name: string;
  email: string;
  address: string;
  birthDate: Date;
  gender: string;
  password: string;
  caregiver: Caregiver = new Caregiver();
  medicalRecord: MedicationPlan[] = [] ;
}
