import { TestBed } from '@angular/core/testing';

import { EdgesGeneratorService } from './edges-generator.service';

describe('EdgesGeneratorService', () => {
  let service: EdgesGeneratorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EdgesGeneratorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
