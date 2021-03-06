import { Bear } from '../models/bear.model';
import { Injectable, Inject } from '@angular/core';
import { Cave } from '../models/cave.model';
import { BearType } from '../models/bear-type.model';

@Injectable()
export class BearService 
{
    public getBears(): Bear[] 
    {
        const bears: Array<Bear> = new Array;
        const cave1: Cave = new Cave(7, 'Tampa', 6);
        const bearType1: BearType = new BearType(4, 'Grizzly');
        bears.push(new Bear(3, "Betty", cave1, bearType1, 300, new Date()));
        bears.push(new Bear(4, "Bob", cave1, bearType1, 400, new Date()));
        bears.push(new Bear(71, "Gandolf", cave1, bearType1, 200, new Date()));
        return bears;
    }
}
