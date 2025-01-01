import { NgModule } from "@angular/core";
import { CommonModule } from '@angular/common'; // Add CommonModule for common Angular directives
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // For form-related components (if required)

import { NzAffixModule } from "ng-zorro-antd/affix";
import { NzAlertModule } from "ng-zorro-antd/alert";
import { NzAnchorModule } from "ng-zorro-antd/anchor";
import { NzAutocompleteModule } from "ng-zorro-antd/auto-complete";
import { NzAvatarModule } from "ng-zorro-antd/avatar";
import { NzBackTopModule } from "ng-zorro-antd/back-top";
import { NzBreadCrumbModule } from "ng-zorro-antd/breadcrumb";
import { NzButtonModule } from "ng-zorro-antd/button";
import { NzCalendarModule } from "ng-zorro-antd/calendar";
import { NzCardModule } from "ng-zorro-antd/card";
import { NzCarouselModule } from "ng-zorro-antd/carousel";
import { NzCascaderModule } from "ng-zorro-antd/cascader";
import { NzCheckboxModule } from "ng-zorro-antd/checkbox";
import { NzCollapseModule } from "ng-zorro-antd/collapse";
import { NzCommentModule } from "ng-zorro-antd/comment";
import { NzNoAnimationModule } from "ng-zorro-antd/core/no-animation";
import { NzDatePickerModule } from "ng-zorro-antd/date-picker";
import { NzDescriptionsModule } from "ng-zorro-antd/descriptions";
import { NzDividerModule } from "ng-zorro-antd/divider";
import { NzDrawerModule } from "ng-zorro-antd/drawer";
import { NzDropDownModule } from "ng-zorro-antd/dropdown";
import { NzEmptyModule } from "ng-zorro-antd/empty";
import { NzFormModule } from "ng-zorro-antd/form";
import { NzGridModule } from "ng-zorro-antd/grid";
import { NzI18nModule } from "ng-zorro-antd/i18n";
import { NzIconModule } from "ng-zorro-antd/icon";
import { NzImageModule } from "ng-zorro-antd/image";
import { NzInputModule } from "ng-zorro-antd/input";
import { NzInputNumberModule } from "ng-zorro-antd/input-number";
import { NzLayoutModule } from "ng-zorro-antd/layout";
import { NzListModule } from "ng-zorro-antd/list";
import { NzMentionModule } from "ng-zorro-antd/mention";
import { NzMenuModule } from "ng-zorro-antd/menu";
import { NzMessageModule } from "ng-zorro-antd/message";
import { NzModalModule } from "ng-zorro-antd/modal";
import { NzNotificationModule } from "ng-zorro-antd/notification";
import { NzPageHeaderModule } from "ng-zorro-antd/page-header";
import { NzPaginationModule } from "ng-zorro-antd/pagination";
import { NzPipesModule } from "ng-zorro-antd/pipes";
import { NzPopconfirmModule } from "ng-zorro-antd/popconfirm";
import { NzResizableModule } from "ng-zorro-antd/resizable";
import { NzPopoverModule } from "ng-zorro-antd/popover"; // Import NzPopoverModule
import { NzProgressModule } from "ng-zorro-antd/progress"; // Import NzProgressModule
import { NzRadioModule } from "ng-zorro-antd/radio"; // Import NzRadioModule
import { NzRateModule } from "ng-zorro-antd/rate"; // Import NzRateModule
import { NzResultModule } from "ng-zorro-antd/result"; // Import NzResultModule
import { NzSelectModule } from "ng-zorro-antd/select"; // Import NzSelectModule
import { NzSkeletonModule } from "ng-zorro-antd/skeleton"; // Import NzSkeletonModule
import { NzSliderModule } from "ng-zorro-antd/slider"; // Import NzSliderModule
import { NzSpinModule } from "ng-zorro-antd/spin"; // Import NzSpinModule
import { NzStatisticModule } from "ng-zorro-antd/statistic"; // Import NzStatisticModule
import { NzStepsModule } from "ng-zorro-antd/steps"; // Import NzStepsModule
import { NzSwitchModule } from "ng-zorro-antd/switch"; // Import NzSwitchModule
import { NzTableModule } from "ng-zorro-antd/table"; // Import NzTableModule
import { NzTabsModule } from "ng-zorro-antd/tabs"; // Import NzTabsModule
import { NzTagModule } from "ng-zorro-antd/tag"; // Import NzTagModule
import { NzTimePickerModule } from "ng-zorro-antd/time-picker"; // Import NzTimePickerModule
import { NzTimelineModule } from "ng-zorro-antd/timeline"; // Import NzTimelineModule
import { NzToolTipModule } from "ng-zorro-antd/tooltip"; // Import NzToolTipModule
import { NzTransferModule } from "ng-zorro-antd/transfer"; // Import NzTransferModule
import { NzTreeModule } from "ng-zorro-antd/tree"; // Import NzTreeModule
import { NzTreeViewModule } from "ng-zorro-antd/tree-view"; // Import NzTreeViewModule
import { NzTreeSelectModule } from "ng-zorro-antd/tree-select"; // Import NzTreeSelectModule
import { NzTypographyModule } from "ng-zorro-antd/typography"; // Import NzTypographyModule
import { NzUploadModule } from "ng-zorro-antd/upload"; // Import NzUploadModule
import { NzWaveModule } from "ng-zorro-antd/core/wave";
// import { NzWaveModule } from "ng-zorro-antd/wave"; // Import NzWaveModule

@NgModule({
  imports: [
    CommonModule, 
    FormsModule, 
    ReactiveFormsModule, 
    NzAffixModule,
    NzAlertModule,
    NzAnchorModule,
    NzAutocompleteModule,
    NzAvatarModule,
    NzBackTopModule,
    NzBreadCrumbModule,
    NzButtonModule,
    NzCalendarModule,
    NzCardModule,
    NzCarouselModule,
    NzCascaderModule,
    NzCheckboxModule,
    NzCollapseModule,
    NzCommentModule,
    NzDatePickerModule,
    NzDescriptionsModule,
    NzDividerModule,
    NzDrawerModule,
    NzDropDownModule,
    NzEmptyModule,
    NzFormModule,
    NzGridModule,
    NzI18nModule,
    NzIconModule,
    NzImageModule,
    NzInputModule,
    NzInputNumberModule,
    NzLayoutModule,
    NzListModule,
    NzMentionModule,
    NzMenuModule,
    NzMessageModule,
    NzModalModule,
    NzNoAnimationModule,
    NzNotificationModule,
    NzPageHeaderModule,
    NzPaginationModule,
    NzPopconfirmModule,
    NzResizableModule,
    NzPopoverModule,
    NzProgressModule,
    NzRadioModule,
    NzRateModule,
    NzResultModule,
    NzSelectModule,
    NzSkeletonModule,
    NzSliderModule,
    NzSpinModule,
    NzStatisticModule,
    NzStepsModule,
    NzSwitchModule,
    NzTableModule,
    NzTabsModule,
    NzTagModule,
    NzTimePickerModule,
    NzTimelineModule,
    NzToolTipModule,
    NzTransferModule,
    NzTreeModule,
    NzTreeViewModule,
    NzTreeSelectModule,
    NzTypographyModule,
    NzUploadModule,
    NzWaveModule
  ],
  exports: [
    NzAffixModule,
    NzAlertModule,
    NzAnchorModule,
    NzAutocompleteModule,
    NzAvatarModule,
    NzBackTopModule,
    NzBreadCrumbModule,
    NzButtonModule,
    NzCalendarModule,
    NzCardModule,
    NzCarouselModule,
    NzCascaderModule,
    NzCheckboxModule,
    NzCollapseModule,
    NzCommentModule,
    NzDatePickerModule,
    NzDescriptionsModule,
    NzDividerModule,
    NzDrawerModule,
    NzDropDownModule,
    NzEmptyModule,
    NzFormModule,
    NzGridModule,
    NzI18nModule,
    NzIconModule,
    NzImageModule,
    NzInputModule,
    NzInputNumberModule,
    NzLayoutModule,
    NzListModule,
    NzMentionModule,
    NzMenuModule,
    NzMessageModule,
    NzModalModule,
    NzNoAnimationModule,
    NzNotificationModule,
    NzPageHeaderModule,
    NzPaginationModule,
    NzPopconfirmModule,
    NzResizableModule,
    NzPopoverModule,
    NzProgressModule,
    NzRadioModule,
    NzRateModule,
    NzResultModule,
    NzSelectModule,
    NzSkeletonModule,
    NzSliderModule,
    NzSpinModule,
    NzStatisticModule,
    NzStepsModule,
    NzSwitchModule,
    NzTableModule,
    NzTabsModule,
    NzTagModule,
    NzTimePickerModule,
    NzTimelineModule,
    NzToolTipModule,
    NzTransferModule,
    NzTreeModule,
    NzTreeViewModule,
    NzTreeSelectModule,
    NzTypographyModule,
    NzUploadModule,
    NzWaveModule
  ]
})
export class DemoNgZorroAntdModule {}
