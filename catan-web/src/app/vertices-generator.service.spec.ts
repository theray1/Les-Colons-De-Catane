import { TestBed } from '@angular/core/testing';

import { VerticesGeneratorService } from './vertices-generator.service';

describe('VerticesGeneratorService', () => {
  let service: VerticesGeneratorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VerticesGeneratorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
