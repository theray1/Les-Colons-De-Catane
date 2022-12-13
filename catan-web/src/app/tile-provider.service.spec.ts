import { TestBed } from '@angular/core/testing';

import { TileProviderService } from './tile-provider.service';

describe('TileProviderService', () => {
  let service: TileProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TileProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
