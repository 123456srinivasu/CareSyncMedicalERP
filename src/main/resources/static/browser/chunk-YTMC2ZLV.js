import{a as Ee}from"./chunk-Y563OKYY.js";import{e as re}from"./chunk-QYSZXZM2.js";import{a as ke}from"./chunk-3QAS3NUA.js";import{a as $e,b as Pe}from"./chunk-U73DU4T3.js";import"./chunk-4N5RVAAF.js";import"./chunk-WGLIF7H7.js";import"./chunk-BHOGWTE3.js";import{a as Se,b as Oe}from"./chunk-SPZLS4EX.js";import{c as ve,d as we,h as Ie,j as Te}from"./chunk-RF7ZIVK6.js";import{j as he,l as Ce,o as be,x as ye,y as xe,z as Me}from"./chunk-YGLKYNKB.js";import"./chunk-ZMVKRBMA.js";import{c as le,d as R,f as q,h as B,p as me}from"./chunk-V6BA4PFG.js";import{a as _e,b as fe}from"./chunk-K3VKWZ5H.js";import{Bb as w,C as j,Cb as I,Db as te,Dd as D,Eb as g,Fa as K,Fb as ne,Hd as E,Ia as c,Ib as y,Id as z,Jb as x,Kb as M,Kd as ce,Lb as S,Md as pe,N as H,Nb as F,O as Y,Ob as oe,Sa as T,T as b,Ta as U,Vd as ge,Wa as X,Ya as m,Yb as se,Yd as de,Z as _,Zd as ue,_ as f,aa as A,ac as N,cb as V,db as a,fa as G,ib as h,ka as J,m as W,mb as r,nb as l,ob as C,pc as ie,rb as $,rc as O,sb as P,tc as ae,ub as u,vb as p,wb as Z,xb as ee,xc as k,y as Q,zb as v}from"./chunk-BH5DC4B6.js";var Re=["container"],qe=["icon"],Be=["closeicon"],De=["*"],Le=(e,o)=>({showTransitionParams:e,hideTransitionParams:o}),We=e=>({value:"visible()",params:e}),Qe=e=>({closeCallback:e});function je(e,o){e&1&&$(0)}function He(e,o){if(e&1&&m(0,je,1,0,"ng-container",7),e&2){let t=p(2);a("ngTemplateOutlet",t.iconTemplate||t.iconTemplate)}}function Ye(e,o){if(e&1&&C(0,"i",3),e&2){let t=p(2);a("ngClass",t.icon)}}function Ge(e,o){if(e&1&&C(0,"span",9),e&2){let t=p(3);a("ngClass",t.cx("text"))("innerHTML",t.text,K)}}function Je(e,o){if(e&1&&(r(0,"div"),m(1,Ge,1,2,"span",8),l()),e&2){let t=p(2);c(),a("ngIf",!t.escape)}}function Ke(e,o){if(e&1&&(r(0,"span",5),g(1),l()),e&2){let t=p(3);a("ngClass",t.cx("text")),c(),ne(t.text)}}function Ue(e,o){if(e&1&&m(0,Ke,2,2,"span",10),e&2){let t=p(2);a("ngIf",t.escape&&t.text)}}function Xe(e,o){e&1&&$(0)}function Ze(e,o){if(e&1&&m(0,Xe,1,0,"ng-container",11),e&2){let t=p(2);a("ngTemplateOutlet",t.containerTemplate||t.containerTemplate)("ngTemplateOutletContext",F(2,Qe,t.close.bind(t)))}}function et(e,o){if(e&1&&(r(0,"span",5),ee(1),l()),e&2){let t=p(2);a("ngClass",t.cx("text"))}}function tt(e,o){if(e&1&&C(0,"i",13),e&2){let t=p(3);a("ngClass",t.closeIcon)}}function nt(e,o){e&1&&$(0)}function ot(e,o){if(e&1&&m(0,nt,1,0,"ng-container",7),e&2){let t=p(3);a("ngTemplateOutlet",t.closeIconTemplate||t._closeIconTemplate)}}function st(e,o){e&1&&C(0,"TimesIcon",14)}function it(e,o){if(e&1){let t=P();r(0,"button",12),u("click",function(s){_(t);let i=p(2);return f(i.close(s))}),m(1,tt,1,1,"i",13)(2,ot,1,1,"ng-container")(3,st,1,0,"TimesIcon",14),l()}if(e&2){let t=p(2);V("aria-label",t.closeAriaLabel),c(),h(t.closeIcon?1:-1),c(),h(t.closeIconTemplate||t._closeIconTemplate?2:-1),c(),h(!t.closeIconTemplate&&!t._closeIconTemplate&&!t.closeIcon?3:-1)}}function at(e,o){if(e&1&&(r(0,"div",1)(1,"div",2),m(2,He,1,1,"ng-container")(3,Ye,1,1,"i",3)(4,Je,2,1,"div",4)(5,Ue,1,1,"ng-template",null,0,se)(7,Ze,1,4,"ng-container")(8,et,2,1,"span",5)(9,it,4,4,"button",6),l()()),e&2){let t=te(6),n=p();a("ngClass",n.containerClass)("@messageAnimation",F(13,We,oe(10,Le,n.showTransitionOptions,n.hideTransitionOptions))),V("aria-live","polite")("role","alert"),c(2),h(n.iconTemplate||n._iconTemplate?2:-1),c(),h(n.icon?3:-1),c(),a("ngIf",!n.escape)("ngIfElse",t),c(3),h(n.containerTemplate||n._containerTemplate?7:8),c(2),h(n.closable?9:-1)}}var rt=({dt:e})=>`
.p-message {
    border-radius: ${e("message.border.radius")};
    outline-width: ${e("message.border.width")};
    outline-style: solid;
}

.p-message-content {
    display: flex;
    align-items: center;
    padding: ${e("message.content.padding")};
    gap: ${e("message.content.gap")};
    height: 100%;
}

.p-message-icon {
    flex-shrink: 0;
}

.p-message-close-button {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-shrink: 0;
    margin-inline-start: auto;
    overflow: hidden;
    position: relative;
    width: ${e("message.close.button.width")};
    height: ${e("message.close.button.height")};
    border-radius: ${e("message.close.button.border.radius")};
    background: transparent;
    transition: background ${e("message.transition.duration")}, color ${e("message.transition.duration")}, outline-color ${e("message.transition.duration")}, box-shadow ${e("message.transition.duration")}, opacity 0.3s;
    outline-color: transparent;
    color: inherit;
    padding: 0;
    border: none;
    cursor: pointer;
    user-select: none;
}

.p-message-close-icon {
    font-size: ${e("message.close.icon.size")};
    width: ${e("message.close.icon.size")};
    height: ${e("message.close.icon.size")};
}

.p-message-close-button:focus-visible {
    outline-width: ${e("message.close.button.focus.ring.width")};
    outline-style: ${e("message.close.button.focus.ring.style")};
    outline-offset: ${e("message.close.button.focus.ring.offset")};
}

.p-message-info {
    background: ${e("message.info.background")};
    outline-color: ${e("message.info.border.color")};
    color: ${e("message.info.color")};
    box-shadow: ${e("message.info.shadow")};
}

.p-message-info .p-message-close-button:focus-visible {
    outline-color: ${e("message.info.close.button.focus.ring.color")};
    box-shadow: ${e("message.info.close.button.focus.ring.shadow")};
}

.p-message-info .p-message-close-button:hover {
    background: ${e("message.info.close.button.hover.background")};
}

.p-message-info.p-message-outlined {
    color: ${e("message.info.outlined.color")};
    outline-color: ${e("message.info.outlined.border.color")};
}

.p-message-info.p-message-simple {
    color: ${e("message.info.simple.color")};
}

.p-message-success {
    background: ${e("message.success.background")};
    outline-color: ${e("message.success.border.color")};
    color: ${e("message.success.color")};
    box-shadow: ${e("message.success.shadow")};
}

.p-message-success .p-message-close-button:focus-visible {
    outline-color: ${e("message.success.close.button.focus.ring.color")};
    box-shadow: ${e("message.success.close.button.focus.ring.shadow")};
}

.p-message-success .p-message-close-button:hover {
    background: ${e("message.success.close.button.hover.background")};
}

.p-message-success.p-message-outlined {
    color: ${e("message.success.outlined.color")};
    outline-color: ${e("message.success.outlined.border.color")};
}

.p-message-success.p-message-simple {
    color: ${e("message.success.simple.color")};
}

.p-message-warn {
    background: ${e("message.warn.background")};
    outline-color: ${e("message.warn.border.color")};
    color: ${e("message.warn.color")};
    box-shadow: ${e("message.warn.shadow")};
}

.p-message-warn .p-message-close-button:focus-visible {
    outline-color: ${e("message.warn.close.button.focus.ring.color")};
    box-shadow: ${e("message.warn.close.button.focus.ring.shadow")};
}

.p-message-warn .p-message-close-button:hover {
    background: ${e("message.warn.close.button.hover.background")};
}

.p-message-warn.p-message-outlined {
    color: ${e("message.warn.outlined.color")};
    outline-color: ${e("message.warn.outlined.border.color")};
}

.p-message-warn.p-message-simple {
    color: ${e("message.warn.simple.color")};
}

.p-message-error {
    background: ${e("message.error.background")};
    outline-color: ${e("message.error.border.color")};
    color: ${e("message.error.color")};
    box-shadow: ${e("message.error.shadow")};
}

.p-message-error .p-message-close-button:focus-visible {
    outline-color: ${e("message.error.close.button.focus.ring.color")};
    box-shadow: ${e("message.error.close.button.focus.ring.shadow")};
}

.p-message-error .p-message-close-button:hover {
    background: ${e("message.error.close.button.hover.background")};
}

.p-message-error.p-message-outlined {
    color: ${e("message.error.outlined.color")};
    outline-color: ${e("message.error.outlined.border.color")};
}

.p-message-error.p-message-simple {
    color: ${e("message.error.simple.color")};
}

.p-message-secondary {
    background: ${e("message.secondary.background")};
    outline-color: ${e("message.secondary.border.color")};
    color: ${e("message.secondary.color")};
    box-shadow: ${e("message.secondary.shadow")};
}

.p-message-secondary .p-message-close-button:focus-visible {
    outline-color: ${e("message.secondary.close.button.focus.ring.color")};
    box-shadow: ${e("message.secondary.close.button.focus.ring.shadow")};
}

.p-message-secondary .p-message-close-button:hover {
    background: ${e("message.secondary.close.button.hover.background")};
}

.p-message-secondary.p-message-outlined {
    color: ${e("message.secondary.outlined.color")};
    outline-color: ${e("message.secondary.outlined.border.color")};
}

.p-message-secondary.p-message-simple {
    color: ${e("message.secondary.simple.color")};
}

.p-message-contrast {
    background: ${e("message.contrast.background")};
    outline-color: ${e("message.contrast.border.color")};
    color: ${e("message.contrast.color")};
    box-shadow: ${e("message.contrast.shadow")};
}

.p-message-contrast .p-message-close-button:focus-visible {
    outline-color: ${e("message.contrast.close.button.focus.ring.color")};
    box-shadow: ${e("message.contrast.close.button.focus.ring.shadow")};
}

.p-message-contrast .p-message-close-button:hover {
    background: ${e("message.contrast.close.button.hover.background")};
}

.p-message-contrast.p-message-outlined {
    color: ${e("message.contrast.outlined.color")};
    outline-color: ${e("message.contrast.outlined.border.color")};
}

.p-message-contrast.p-message-simple {
    color: ${e("message.contrast.simple.color")};
}

.p-message-text {
    display: inline-flex;
    align-items: center;
    font-size: ${e("message.text.font.size")};
    font-weight: ${e("message.text.font.weight")};
}

.p-message-icon {
    font-size: ${e("message.icon.size")};
    width: ${e("message.icon.size")};
    height: ${e("message.icon.size")};
}

.p-message-enter-from {
    opacity: 0;
}

.p-message-enter-active {
    transition: opacity 0.3s;
}

.p-message.p-message-leave-from {
    max-height: 1000px;
}

.p-message.p-message-leave-to {
    max-height: 0;
    opacity: 0;
    margin: 0;
}

.p-message-leave-active {
    overflow: hidden;
    transition: max-height 0.45s cubic-bezier(0, 1, 0, 1), opacity 0.3s, margin 0.3s;
}

.p-message-leave-active .p-message-close-button {
    opacity: 0;
}

.p-message-sm .p-message-content {
    padding: ${e("message.content.sm.padding")};
}

.p-message-sm .p-message-text {
    font-size: ${e("message.text.sm.font.size")};
}

.p-message-sm .p-message-icon {
    font-size: ${e("message.icon.sm.size")};
    width: ${e("message.icon.sm.size")};
    height: ${e("message.icon.sm.size")};
}

.p-message-sm .p-message-close-icon {
    font-size: ${e("message.close.icon.sm.size")};
    width: ${e("message.close.icon.sm.size")};
    height: ${e("message.close.icon.sm.size")};
}

.p-message-lg .p-message-content {
    padding: ${e("message.content.lg.padding")};
}

.p-message-lg .p-message-text {
    font-size: ${e("message.text.lg.font.size")};
}

.p-message-lg .p-message-icon {
    font-size: ${e("message.icon.lg.size")};
    width: ${e("message.icon.lg.size")};
    height: ${e("message.icon.lg.size")};
}

.p-message-lg .p-message-close-icon {
    font-size: ${e("message.close.icon.lg.size")};
    width: ${e("message.close.icon.lg.size")};
    height: ${e("message.close.icon.lg.size")};
}

.p-message-outlined {
    background: transparent;
    outline-width: ${e("message.outlined.border.width")};
}

.p-message-simple {
    background: transparent;
    outline-color: transparent;
    box-shadow: none;
}

.p-message-simple .p-message-content {
    padding: ${e("message.simple.content.padding")};
}

.p-message-outlined .p-message-close-button:hover,
.p-message-simple .p-message-close-button:hover {
    background: transparent;
}`,lt={root:({props:e})=>["p-message p-component p-message-"+e.severity,{"p-message-simple":e.variant==="simple"}],content:"p-message-content",icon:"p-message-icon",text:"p-message-text",closeButton:"p-message-close-button",closeIcon:"p-message-close-icon"},ze=(()=>{class e extends ce{name="message";theme=rt;classes=lt;static \u0275fac=(()=>{let t;return function(s){return(t||(t=A(e)))(s||e)}})();static \u0275prov=H({token:e,factory:e.\u0275fac})}return e})();var L=(()=>{class e extends pe{severity="info";text;escape=!0;style;styleClass;closable=!1;icon;closeIcon;life;showTransitionOptions="300ms ease-out";hideTransitionOptions="200ms cubic-bezier(0.86, 0, 0.07, 1)";size;variant;onClose=new G;get closeAriaLabel(){return this.config.translation.aria?this.config.translation.aria.close:void 0}get containerClass(){let t=this.variant==="outlined"?"p-message-outlined":this.variant==="simple"?"p-message-simple":"",n=this.size==="small"?"p-message-sm":this.size==="large"?"p-message-lg":"";return`p-message-${this.severity} ${t} ${n}`.trim()+(this.styleClass?" "+this.styleClass:"")}visible=J(!0);_componentStyle=b(ze);containerTemplate;iconTemplate;closeIconTemplate;templates;_containerTemplate;_iconTemplate;_closeIconTemplate;ngOnInit(){super.ngOnInit(),this.life&&setTimeout(()=>{this.visible.set(!1)},this.life)}ngAfterContentInit(){this.templates?.forEach(t=>{switch(t.getType()){case"container":this._containerTemplate=t.template;break;case"icon":this._iconTemplate=t.template;break;case"closeicon":this._closeIconTemplate=t.template;break}})}close(t){this.visible.set(!1),this.onClose.emit({originalEvent:t})}static \u0275fac=(()=>{let t;return function(s){return(t||(t=A(e)))(s||e)}})();static \u0275cmp=T({type:e,selectors:[["p-message"]],contentQueries:function(n,s,i){if(n&1&&(v(i,Re,4),v(i,qe,4),v(i,Be,4),v(i,E,4)),n&2){let d;w(d=I())&&(s.containerTemplate=d.first),w(d=I())&&(s.iconTemplate=d.first),w(d=I())&&(s.closeIconTemplate=d.first),w(d=I())&&(s.templates=d)}},inputs:{severity:"severity",text:"text",escape:[2,"escape","escape",N],style:"style",styleClass:"styleClass",closable:[2,"closable","closable",N],icon:"icon",closeIcon:"closeIcon",life:"life",showTransitionOptions:"showTransitionOptions",hideTransitionOptions:"hideTransitionOptions",size:"size",variant:"variant"},outputs:{onClose:"onClose"},features:[S([ze]),X],ngContentSelectors:De,decls:1,vars:1,consts:[["escapeOut",""],[1,"p-message","p-component",3,"ngClass"],[1,"p-message-content"],[1,"p-message-icon",3,"ngClass"],[4,"ngIf","ngIfElse"],[3,"ngClass"],["pRipple","","type","button",1,"p-message-close-button"],[4,"ngTemplateOutlet"],[3,"ngClass","innerHTML",4,"ngIf"],[3,"ngClass","innerHTML"],[3,"ngClass",4,"ngIf"],[4,"ngTemplateOutlet","ngTemplateOutletContext"],["pRipple","","type","button",1,"p-message-close-button",3,"click"],[1,"p-message-close-icon",3,"ngClass"],["styleClass","p-message-close-icon"]],template:function(n,s){n&1&&(Z(),m(0,at,10,15,"div",1)),n&2&&h(s.visible()?0:-1)},dependencies:[k,ie,O,ae,me,ge,z],encapsulation:2,data:{animation:[le("messageAnimation",[B(":enter",[q({opacity:0,transform:"translateY(-25%)"}),R("{{showTransitionParams}}")]),B(":leave",[R("{{hideTransitionParams}}",q({height:0,marginTop:0,marginBottom:0,marginLeft:0,marginRight:0,opacity:0}))])])]},changeDetection:0})}return e})(),Ae=(()=>{class e{static \u0275fac=function(n){return new(n||e)};static \u0275mod=U({type:e});static \u0275inj=Y({imports:[L,z,z]})}return e})();function pt(e,o){e&1&&(r(0,"small",20),g(1,"Loading camps..."),l())}function mt(e,o){if(e&1&&C(0,"p-message",21),e&2){let t=p();a("text",t.errorMessage)}}function gt(e,o){if(e&1&&C(0,"p-message",22),e&2){let t=p();a("text",t.successMessage)}}function dt(e,o){e&1&&(r(0,"tr")(1,"th",27),g(2,"Supplier"),l(),r(3,"th",27),g(4,"Medicine"),l(),r(5,"th",28),g(6,"Quantity"),l(),r(7,"th",29),g(8,"Action"),l()())}function ut(e,o){if(e&1){let t=P();r(0,"tr")(1,"td")(2,"p-dropdown",30),M("ngModelChange",function(s){let i=_(t).$implicit;return x(i.supplierId,s)||(i.supplierId=s),f(s)}),u("onChange",function(){let s=_(t).rowIndex,i=p(2);return f(i.onSupplierChange(s))}),l()(),r(3,"td")(4,"p-dropdown",31),M("ngModelChange",function(s){let i=_(t).$implicit;return x(i.medicineId,s)||(i.medicineId=s),f(s)}),u("onChange",function(){_(t);let s=p(2);return f(s.onMedicineSelect())}),l()(),r(5,"td")(6,"p-inputNumber",32),M("ngModelChange",function(s){let i=_(t).$implicit;return x(i.quantity,s)||(i.quantity=s),f(s)}),l()(),r(7,"td")(8,"p-button",33),u("onClick",function(){let s=_(t).rowIndex,i=p(2);return f(i.removeMedicineRow(s))}),l()()()}if(e&2){let t=o.$implicit,n=o.rowIndex,s=p(2);c(2),y("ngModel",t.supplierId),a("options",s.supplierOptions),c(2),y("ngModel",t.medicineId),a("options",s.getMedicineOptionsForRow(n)),c(2),y("ngModel",t.quantity),a("min",1)("showButtons",!0),c(2),a("text",!0)}}function _t(e,o){e&1&&(r(0,"tr")(1,"td",34),g(2,"No medicines added."),l()())}function ft(e,o){if(e&1&&(r(0,"p-table",23),m(1,dt,9,0,"ng-template",24)(2,ut,9,8,"ng-template",25)(3,_t,3,0,"ng-template",26),l()),e&2){let t=p();a("value",t.orderItems)}}var Ve=class e{campsService=b(ke);suppliersService=b(Ee);messageService=b(D);router=b(re);campOptions=[];selectedCampId;loading=!1;errorMessage="";successMessage="";orderComments="";suppliers=[];orderItems=[];supplierOptions=[];ngOnInit(){this.loadCamps(),this.loadSuppliers()}loadCamps(){this.loading=!0,this.campsService.getAllCamps({status:"All",page:0,size:1e3,sort:"desc"}).subscribe({next:o=>{let t=[];Array.isArray(o?.content)?t=o.content:Array.isArray(o)?t=o:o&&Array.isArray(o.data)&&(t=o.data),this.campOptions=t.map(n=>({label:n.campName||n.camp_code||`Camp ${n.campId}`,value:n.campId})),this.loading=!1},error:o=>{console.error("Error loading camps:",o),this.errorMessage="Failed to load camps. Please try again later.",this.loading=!1}})}loadSuppliers(){this.loading=!0,this.errorMessage="",this.suppliersService.getActivePharmacySuppliers().pipe(Q(o=>(console.error("Error loading suppliers:",o),this.errorMessage="Failed to load suppliers. Please try again later.",this.loading=!1,W([])))).subscribe({next:o=>{this.suppliers=o||[],this.supplierOptions=this.suppliers.map(t=>({label:t.supplierName,value:t.pharmacySupplierId})),this.loading=!1},error:o=>{console.error("Error loading suppliers:",o),this.loading=!1}})}onCampChange(){this.errorMessage=""}clearSelection(){this.selectedCampId=void 0}addMedicineRow(){this.errorMessage="",this.successMessage="",this.orderItems.push({supplierId:void 0,medicineId:void 0,quantity:1})}removeMedicineRow(o){this.orderItems.splice(o,1)}onSupplierChange(o){this.orderItems[o]&&(this.orderItems[o].medicineId=void 0),this.errorMessage="",this.successMessage=""}onMedicineSelect(){this.errorMessage="",this.successMessage=""}getMedicineOptionsForRow(o){let t=this.orderItems[o];if(!t?.supplierId)return[];let n=this.suppliers.find(i=>i.pharmacySupplierId===t.supplierId);if(!n||!n.medications)return[];let s=new Set(this.orderItems.map((i,d)=>d!==o?i.medicineId:void 0).filter(i=>!!i));return n.medications.filter(i=>i.isActive&&!s.has(i.medicationId)).map(i=>({label:`${i.medicationCode} - ${i.medicationName} (${i.medicineType})`,value:i.medicationId}))}createOrder(){if(this.errorMessage="",this.successMessage="",!this.selectedCampId){this.errorMessage="Please select a camp.";return}if(this.orderItems.length===0){this.errorMessage="Please add at least one medicine.";return}for(let[n,s]of this.orderItems.entries()){if(!s.supplierId){this.errorMessage=`Please select supplier for row ${n+1}.`;return}if(!s.medicineId){this.errorMessage=`Please select medicine for row ${n+1}.`;return}if(!s.quantity||s.quantity<=0){this.errorMessage=`Please enter quantity for row ${n+1}.`;return}}let o=new Map;this.orderItems.forEach(n=>{!n.supplierId||!n.medicineId||!n.quantity||(o.has(n.supplierId)||o.set(n.supplierId,{supplierId:n.supplierId,medicines:[]}),o.get(n.supplierId).medicines.push({medicationId:n.medicineId,requestedQuantity:n.quantity}))});let t={campId:this.selectedCampId,requestedBy:"user",remarks:this.orderComments||"",supplierOrders:Array.from(o.values())};this.loading=!0,this.campsService.createCampPurchaseOrder(t).pipe(j(()=>{this.loading=!1})).subscribe({next:n=>{this.successMessage=n?.message||"Order created successfully.",this.messageService.add({severity:"success",summary:"Success",detail:this.successMessage}),this.orderItems=[],this.orderComments=""},error:n=>{console.error("Error creating order:",n);let s=n?.error?.message||(n?.error?.errors&&Array.isArray(n.error.errors)?n.error.errors.map(i=>`${i.field||"Error"}: ${i.message||i}`).join(", "):null)||"Failed to create order. Please try again.";this.errorMessage=s,this.messageService.add({severity:"error",summary:"Error",detail:s})}})}goToReport(){this.router.navigate(["/stock/purchase-medicine-orders-report"])}static \u0275fac=function(t){return new(t||e)};static \u0275cmp=T({type:e,selectors:[["app-purchase-medicine"]],features:[S([D])],decls:28,vars:11,consts:[[1,"purchase-medicine-container"],["header","Purchase Medicine"],[1,"form-container"],[1,"field-row"],[1,"field","flex-1"],["for","camp"],[1,"red-star"],["id","camp","optionLabel","label","optionValue","value","placeholder","Select Camp","appendTo","body",1,"w-full",3,"ngModelChange","onChange","onClear","ngModel","options","showClear","disabled"],["class","loading-text",4,"ngIf"],["for","comments"],["id","comments","pInputText","","placeholder","Add comments for this order",1,"w-full",3,"ngModelChange","ngModel"],[1,"actions"],["label","View Purchase Orders","icon","pi pi-list",3,"onClick"],["severity","error",3,"text",4,"ngIf"],["severity","success",3,"text",4,"ngIf"],[1,"section"],[1,"section-header"],["label","Add Medicine","icon","pi pi-plus",3,"onClick","text"],[3,"value",4,"ngIf"],["label","Create Order",3,"onClick","disabled"],[1,"loading-text"],["severity","error",3,"text"],["severity","success",3,"text"],[3,"value"],["pTemplate","header"],["pTemplate","body"],["pTemplate","emptymessage"],[2,"width","40%"],[2,"width","15%"],[2,"width","5%"],["optionLabel","label","optionValue","value","placeholder","Select Supplier","appendTo","body",1,"w-full",3,"ngModelChange","onChange","ngModel","options"],["optionLabel","label","optionValue","value","placeholder","Select Medicine","appendTo","body",1,"w-full",3,"ngModelChange","onChange","ngModel","options"],["mode","decimal",1,"w-full",3,"ngModelChange","ngModel","min","showButtons"],["icon","pi pi-trash","severity","danger",3,"onClick","text"],["colspan","4",2,"text-align","center","padding","12px"]],template:function(t,n){t&1&&(r(0,"div",0),C(1,"p-toast"),r(2,"p-card",1)(3,"div",2)(4,"div",3)(5,"div",4)(6,"label",5),g(7,"Select Camp "),r(8,"span",6),g(9,"*"),l()(),r(10,"p-dropdown",7),M("ngModelChange",function(i){return x(n.selectedCampId,i)||(n.selectedCampId=i),i}),u("onChange",function(){return n.onCampChange()})("onClear",function(){return n.clearSelection()}),l(),m(11,pt,2,0,"small",8),l(),r(12,"div",4)(13,"label",9),g(14,"Comments"),l(),r(15,"input",10),M("ngModelChange",function(i){return x(n.orderComments,i)||(n.orderComments=i),i}),l()(),r(16,"div",11)(17,"p-button",12),u("onClick",function(){return n.goToReport()}),l()()(),m(18,mt,1,1,"p-message",13)(19,gt,1,1,"p-message",14),r(20,"div",15)(21,"div",16)(22,"h4"),g(23,"Medicines"),l(),r(24,"p-button",17),u("onClick",function(){return n.addMedicineRow()}),l()(),m(25,ft,4,1,"p-table",18),l(),r(26,"div",11)(27,"p-button",19),u("onClick",function(){return n.createOrder()}),l()()()()()),t&2&&(c(10),y("ngModel",n.selectedCampId),a("options",n.campOptions)("showClear",!0)("disabled",n.loading),c(),a("ngIf",n.loading),c(4),y("ngModel",n.orderComments),c(3),a("ngIf",n.errorMessage),c(),a("ngIf",n.successMessage),c(5),a("text",!0),c(),a("ngIf",n.orderItems.length>0),c(2),a("disabled",!n.selectedCampId||n.loading))},dependencies:[k,O,ye,he,Ce,be,fe,_e,E,Oe,Se,ue,de,Ae,L,Pe,$e,Te,Ie,we,ve,Me,xe],styles:[".purchase-medicine-container[_ngcontent-%COMP%]   .form-container[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:16px}.purchase-medicine-container[_ngcontent-%COMP%]   .field-row[_ngcontent-%COMP%]{display:flex;flex-direction:row;gap:12px}.purchase-medicine-container[_ngcontent-%COMP%]   .flex-1[_ngcontent-%COMP%]{width:50%}.purchase-medicine-container[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{display:flex;align-items:flex-end;width:279px}.purchase-medicine-container[_ngcontent-%COMP%]   .field[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:8px}.purchase-medicine-container[_ngcontent-%COMP%]   .field[_ngcontent-%COMP%]   label[_ngcontent-%COMP%]{font-weight:600}.purchase-medicine-container[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{display:flex;justify-content:flex-start;gap:12px}.purchase-medicine-container[_ngcontent-%COMP%]   .loading-text[_ngcontent-%COMP%]{color:#6c757d}.purchase-medicine-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:12px}.purchase-medicine-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]   .section-header[_ngcontent-%COMP%]{display:flex;align-items:center;justify-content:space-between;gap:12px}.purchase-medicine-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]   .section-header[_ngcontent-%COMP%]   h4[_ngcontent-%COMP%]{margin:0}"]})};export{Ve as PurchaseMedicineComponent};
