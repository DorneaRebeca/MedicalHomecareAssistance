import {Patient} from './patient';

export class Caregiver {
  id: number;
  name: string;
  email: string;
  address: string;
  birthDate: Date;
  gender: string;
  password: string;
  patients: Patient[] = [];
}
