import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'organizationTypeFilter'
})
export class OrganizationTypeFilterPipe implements PipeTransform {

  transform(orgTypes, searchType: string, fieldName: string) {
    if( orgTypes === 0 || searchType === ''){
      return orgTypes;
    }
   return orgTypes.filter(type => type[fieldName].
   toLowerCase().indexOf(searchType.toLowerCase()) !== -1);
  }
}
