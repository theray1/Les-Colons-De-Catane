import { TestBed } from '@angular/core/testing';

import { TileImageProviderService } from './tile-image-provider.service';

describe('TileImageProviderService', () => {
  let service: TileImageProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TileImageProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
