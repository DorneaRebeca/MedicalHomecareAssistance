import {Patient} from './patient';
import {Medication} from './medication';

export class MonitoredPill {
  id: number;
  status : string;
  patient : Patient = new Patient();
  medication : Medication = new Medication();
  takenDate : string;
}
