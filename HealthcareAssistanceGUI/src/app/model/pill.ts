import {Medication} from './medication';

export class Pill {
  id: number;
  intakeInterval: string;
  medication: Medication = new Medication();
}
