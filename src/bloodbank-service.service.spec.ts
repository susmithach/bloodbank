import { TestBed } from '@angular/core/testing';

import { BloodbankServiceService } from './bloodbank-service.service';

describe('BloodbankServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BloodbankServiceService = TestBed.get(BloodbankServiceService);
    expect(service).toBeTruthy();
  });
});
