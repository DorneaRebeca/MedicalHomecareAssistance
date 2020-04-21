import {Patient} from './patient';

export class MonitoredData {
  id: number;
  activity: string;
  end: string;
  start: string;
  patient: Patient = new Patient();
  anomaly : boolean;
}
