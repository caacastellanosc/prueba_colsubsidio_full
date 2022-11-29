/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TablaService } from './tabla.service';

describe('Service: Tabla', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TablaService]
    });
  });

  it('should ...', inject([TablaService], (service: TablaService) => {
    expect(service).toBeTruthy();
  }));
});
