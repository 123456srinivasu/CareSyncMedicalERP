import{a as ke}from"./chunk-U3CI7GC3.js";import{a as Se}from"./chunk-XUC4MYGG.js";import{a as Te,b as $e}from"./chunk-RTKPGCCO.js";import"./chunk-4N5RVAAF.js";import"./chunk-T5JV2CCH.js";import"./chunk-DOIX3RTZ.js";import{a as Oe,b as Pe}from"./chunk-OOEJPD6P.js";import{c as ve,d as we,g as Me,i as Ie}from"./chunk-5VDTCGJK.js";import{j as fe,l as he,o as Ce,x as be,y as ye,z as xe}from"./chunk-KE5QUIC2.js";import"./chunk-FRQQX37X.js";import{c as re,d as q,f as B,h as D,p as pe}from"./chunk-OMWBNTAB.js";import{a as ue,b as _e}from"./chunk-25PTQCKN.js";import{Bb as M,C as j,Cb as I,Cd as L,Db as te,Eb as g,Fa as K,Fb as oe,Gd as z,Hd as E,Ia as c,Ib as y,Jb as x,Jd as le,Kb as v,Lb as P,Ld as ce,N as H,Nb as F,O as Y,Ob as ne,Sa as T,T as b,Ta as U,Ud as me,Wa as X,Xd as ge,Ya as m,Yb as se,Yd as de,Z as u,_,aa as A,ac as N,cb as V,db as a,fa as G,ib as f,ka as J,m as W,mb as r,nb as l,ob as h,pc as ie,rb as $,rc as S,sb as O,tc as ae,ub as C,vb as p,wb as Z,wc as k,xb as ee,y as Q,zb as w}from"./chunk-C4MBCT6A.js";var Ne=["container"],qe=["icon"],Be=["closeicon"],De=["*"],Le=(e,n)=>({showTransitionParams:e,hideTransitionParams:n}),Re=e=>({value:"visible()",params:e}),We=e=>({closeCallback:e});function Qe(e,n){e&1&&$(0)}function je(e,n){if(e&1&&m(0,Qe,1,0,"ng-container",7),e&2){let t=p(2);a("ngTemplateOutlet",t.iconTemplate||t.iconTemplate)}}function He(e,n){if(e&1&&h(0,"i",3),e&2){let t=p(2);a("ngClass",t.icon)}}function Ye(e,n){if(e&1&&h(0,"span",9),e&2){let t=p(3);a("ngClass",t.cx("text"))("innerHTML",t.text,K)}}function Ge(e,n){if(e&1&&(r(0,"div"),m(1,Ye,1,2,"span",8),l()),e&2){let t=p(2);c(),a("ngIf",!t.escape)}}function Je(e,n){if(e&1&&(r(0,"span",5),g(1),l()),e&2){let t=p(3);a("ngClass",t.cx("text")),c(),oe(t.text)}}function Ke(e,n){if(e&1&&m(0,Je,2,2,"span",10),e&2){let t=p(2);a("ngIf",t.escape&&t.text)}}function Ue(e,n){e&1&&$(0)}function Xe(e,n){if(e&1&&m(0,Ue,1,0,"ng-container",11),e&2){let t=p(2);a("ngTemplateOutlet",t.containerTemplate||t.containerTemplate)("ngTemplateOutletContext",F(2,We,t.close.bind(t)))}}function Ze(e,n){if(e&1&&(r(0,"span",5),ee(1),l()),e&2){let t=p(2);a("ngClass",t.cx("text"))}}function et(e,n){if(e&1&&h(0,"i",13),e&2){let t=p(3);a("ngClass",t.closeIcon)}}function tt(e,n){e&1&&$(0)}function ot(e,n){if(e&1&&m(0,tt,1,0,"ng-container",7),e&2){let t=p(3);a("ngTemplateOutlet",t.closeIconTemplate||t._closeIconTemplate)}}function nt(e,n){e&1&&h(0,"TimesIcon",14)}function st(e,n){if(e&1){let t=O();r(0,"button",12),C("click",function(s){u(t);let i=p(2);return _(i.close(s))}),m(1,et,1,1,"i",13)(2,ot,1,1,"ng-container")(3,nt,1,0,"TimesIcon",14),l()}if(e&2){let t=p(2);V("aria-label",t.closeAriaLabel),c(),f(t.closeIcon?1:-1),c(),f(t.closeIconTemplate||t._closeIconTemplate?2:-1),c(),f(!t.closeIconTemplate&&!t._closeIconTemplate&&!t.closeIcon?3:-1)}}function it(e,n){if(e&1&&(r(0,"div",1)(1,"div",2),m(2,je,1,1,"ng-container")(3,He,1,1,"i",3)(4,Ge,2,1,"div",4)(5,Ke,1,1,"ng-template",null,0,se)(7,Xe,1,4,"ng-container")(8,Ze,2,1,"span",5)(9,st,4,4,"button",6),l()()),e&2){let t=te(6),o=p();a("ngClass",o.containerClass)("@messageAnimation",F(13,Re,ne(10,Le,o.showTransitionOptions,o.hideTransitionOptions))),V("aria-live","polite")("role","alert"),c(2),f(o.iconTemplate||o._iconTemplate?2:-1),c(),f(o.icon?3:-1),c(),a("ngIf",!o.escape)("ngIfElse",t),c(3),f(o.containerTemplate||o._containerTemplate?7:8),c(2),f(o.closable?9:-1)}}var at=({dt:e})=>`
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
}`,rt={root:({props:e})=>["p-message p-component p-message-"+e.severity,{"p-message-simple":e.variant==="simple"}],content:"p-message-content",icon:"p-message-icon",text:"p-message-text",closeButton:"p-message-close-button",closeIcon:"p-message-close-icon"},ze=(()=>{class e extends le{name="message";theme=at;classes=rt;static \u0275fac=(()=>{let t;return function(s){return(t||(t=A(e)))(s||e)}})();static \u0275prov=H({token:e,factory:e.\u0275fac})}return e})();var R=(()=>{class e extends ce{severity="info";text;escape=!0;style;styleClass;closable=!1;icon;closeIcon;life;showTransitionOptions="300ms ease-out";hideTransitionOptions="200ms cubic-bezier(0.86, 0, 0.07, 1)";size;variant;onClose=new G;get closeAriaLabel(){return this.config.translation.aria?this.config.translation.aria.close:void 0}get containerClass(){let t=this.variant==="outlined"?"p-message-outlined":this.variant==="simple"?"p-message-simple":"",o=this.size==="small"?"p-message-sm":this.size==="large"?"p-message-lg":"";return`p-message-${this.severity} ${t} ${o}`.trim()+(this.styleClass?" "+this.styleClass:"")}visible=J(!0);_componentStyle=b(ze);containerTemplate;iconTemplate;closeIconTemplate;templates;_containerTemplate;_iconTemplate;_closeIconTemplate;ngOnInit(){super.ngOnInit(),this.life&&setTimeout(()=>{this.visible.set(!1)},this.life)}ngAfterContentInit(){this.templates?.forEach(t=>{switch(t.getType()){case"container":this._containerTemplate=t.template;break;case"icon":this._iconTemplate=t.template;break;case"closeicon":this._closeIconTemplate=t.template;break}})}close(t){this.visible.set(!1),this.onClose.emit({originalEvent:t})}static \u0275fac=(()=>{let t;return function(s){return(t||(t=A(e)))(s||e)}})();static \u0275cmp=T({type:e,selectors:[["p-message"]],contentQueries:function(o,s,i){if(o&1&&(w(i,Ne,4),w(i,qe,4),w(i,Be,4),w(i,z,4)),o&2){let d;M(d=I())&&(s.containerTemplate=d.first),M(d=I())&&(s.iconTemplate=d.first),M(d=I())&&(s.closeIconTemplate=d.first),M(d=I())&&(s.templates=d)}},inputs:{severity:"severity",text:"text",escape:[2,"escape","escape",N],style:"style",styleClass:"styleClass",closable:[2,"closable","closable",N],icon:"icon",closeIcon:"closeIcon",life:"life",showTransitionOptions:"showTransitionOptions",hideTransitionOptions:"hideTransitionOptions",size:"size",variant:"variant"},outputs:{onClose:"onClose"},features:[P([ze]),X],ngContentSelectors:De,decls:1,vars:1,consts:[["escapeOut",""],[1,"p-message","p-component",3,"ngClass"],[1,"p-message-content"],[1,"p-message-icon",3,"ngClass"],[4,"ngIf","ngIfElse"],[3,"ngClass"],["pRipple","","type","button",1,"p-message-close-button"],[4,"ngTemplateOutlet"],[3,"ngClass","innerHTML",4,"ngIf"],[3,"ngClass","innerHTML"],[3,"ngClass",4,"ngIf"],[4,"ngTemplateOutlet","ngTemplateOutletContext"],["pRipple","","type","button",1,"p-message-close-button",3,"click"],[1,"p-message-close-icon",3,"ngClass"],["styleClass","p-message-close-icon"]],template:function(o,s){o&1&&(Z(),m(0,it,10,15,"div",1)),o&2&&f(s.visible()?0:-1)},dependencies:[k,ie,S,ae,pe,me,E],encapsulation:2,data:{animation:[re("messageAnimation",[D(":enter",[B({opacity:0,transform:"translateY(-25%)"}),q("{{showTransitionParams}}")]),D(":leave",[q("{{hideTransitionParams}}",B({height:0,marginTop:0,marginBottom:0,marginLeft:0,marginRight:0,opacity:0}))])])]},changeDetection:0})}return e})(),Ee=(()=>{class e{static \u0275fac=function(o){return new(o||e)};static \u0275mod=U({type:e});static \u0275inj=Y({imports:[R,E,E]})}return e})();function ct(e,n){e&1&&(r(0,"small",19),g(1,"Loading camps..."),l())}function pt(e,n){if(e&1&&h(0,"p-message",20),e&2){let t=p();a("text",t.errorMessage)}}function mt(e,n){if(e&1&&h(0,"p-message",21),e&2){let t=p();a("text",t.successMessage)}}function gt(e,n){e&1&&(r(0,"tr")(1,"th",26),g(2,"Supplier"),l(),r(3,"th",26),g(4,"Medicine"),l(),r(5,"th",27),g(6,"Quantity"),l(),r(7,"th",28),g(8,"Action"),l()())}function dt(e,n){if(e&1){let t=O();r(0,"tr")(1,"td")(2,"p-dropdown",29),v("ngModelChange",function(s){let i=u(t).$implicit;return x(i.supplierId,s)||(i.supplierId=s),_(s)}),C("onChange",function(){let s=u(t).rowIndex,i=p(2);return _(i.onSupplierChange(s))}),l()(),r(3,"td")(4,"p-dropdown",30),v("ngModelChange",function(s){let i=u(t).$implicit;return x(i.medicineId,s)||(i.medicineId=s),_(s)}),C("onChange",function(){u(t);let s=p(2);return _(s.onMedicineSelect())}),l()(),r(5,"td")(6,"p-inputNumber",31),v("ngModelChange",function(s){let i=u(t).$implicit;return x(i.quantity,s)||(i.quantity=s),_(s)}),l()(),r(7,"td")(8,"p-button",32),C("onClick",function(){let s=u(t).rowIndex,i=p(2);return _(i.removeMedicineRow(s))}),l()()()}if(e&2){let t=n.$implicit,o=n.rowIndex,s=p(2);c(2),y("ngModel",t.supplierId),a("options",s.supplierOptions),c(2),y("ngModel",t.medicineId),a("options",s.getMedicineOptionsForRow(o)),c(2),y("ngModel",t.quantity),a("min",1)("showButtons",!0),c(2),a("text",!0)}}function ut(e,n){e&1&&(r(0,"tr")(1,"td",33),g(2,"No medicines added."),l()())}function _t(e,n){if(e&1&&(r(0,"p-table",22),m(1,gt,9,0,"ng-template",23)(2,dt,9,8,"ng-template",24)(3,ut,3,0,"ng-template",25),l()),e&2){let t=p();a("value",t.orderItems)}}var Ae=class e{campsService=b(Se);suppliersService=b(ke);messageService=b(L);campOptions=[];selectedCampId;loading=!1;errorMessage="";successMessage="";orderComments="";suppliers=[];orderItems=[];supplierOptions=[];ngOnInit(){this.loadCamps(),this.loadSuppliers()}loadCamps(){this.loading=!0,this.campsService.getAllCamps({status:"All",page:0,size:1e3,sort:"desc"}).subscribe({next:n=>{let t=[];Array.isArray(n?.content)?t=n.content:Array.isArray(n)?t=n:n&&Array.isArray(n.data)&&(t=n.data),this.campOptions=t.map(o=>({label:o.campName||o.camp_code||`Camp ${o.campId}`,value:o.campId})),this.loading=!1},error:n=>{console.error("Error loading camps:",n),this.errorMessage="Failed to load camps. Please try again later.",this.loading=!1}})}loadSuppliers(){this.loading=!0,this.errorMessage="",this.suppliersService.getActivePharmacySuppliers().pipe(Q(n=>(console.error("Error loading suppliers:",n),this.errorMessage="Failed to load suppliers. Please try again later.",this.loading=!1,W([])))).subscribe({next:n=>{this.suppliers=n||[],this.supplierOptions=this.suppliers.map(t=>({label:t.supplierName,value:t.pharmacySupplierId})),this.loading=!1},error:n=>{console.error("Error loading suppliers:",n),this.loading=!1}})}onCampChange(){this.errorMessage=""}clearSelection(){this.selectedCampId=void 0}addMedicineRow(){this.errorMessage="",this.successMessage="",this.orderItems.push({supplierId:void 0,medicineId:void 0,quantity:1})}removeMedicineRow(n){this.orderItems.splice(n,1)}onSupplierChange(n){this.orderItems[n]&&(this.orderItems[n].medicineId=void 0),this.errorMessage="",this.successMessage=""}onMedicineSelect(){this.errorMessage="",this.successMessage=""}getMedicineOptionsForRow(n){let t=this.orderItems[n];if(!t?.supplierId)return[];let o=this.suppliers.find(i=>i.pharmacySupplierId===t.supplierId);if(!o||!o.medications)return[];let s=new Set(this.orderItems.map((i,d)=>d!==n?i.medicineId:void 0).filter(i=>!!i));return o.medications.filter(i=>i.isActive&&!s.has(i.medicationId)).map(i=>({label:`${i.medicationCode} - ${i.medicationName} (${i.medicineType})`,value:i.medicationId}))}createOrder(){if(this.errorMessage="",this.successMessage="",!this.selectedCampId){this.errorMessage="Please select a camp.";return}if(this.orderItems.length===0){this.errorMessage="Please add at least one medicine.";return}for(let[o,s]of this.orderItems.entries()){if(!s.supplierId){this.errorMessage=`Please select supplier for row ${o+1}.`;return}if(!s.medicineId){this.errorMessage=`Please select medicine for row ${o+1}.`;return}if(!s.quantity||s.quantity<=0){this.errorMessage=`Please enter quantity for row ${o+1}.`;return}}let n=new Map;this.orderItems.forEach(o=>{!o.supplierId||!o.medicineId||!o.quantity||(n.has(o.supplierId)||n.set(o.supplierId,{supplierId:o.supplierId,medicines:[]}),n.get(o.supplierId).medicines.push({medicationId:o.medicineId,requestedQuantity:o.quantity}))});let t={campId:this.selectedCampId,requestedBy:"user",remarks:this.orderComments||"",supplierOrders:Array.from(n.values())};this.loading=!0,this.campsService.createCampPurchaseOrder(t).pipe(j(()=>{this.loading=!1})).subscribe({next:o=>{this.successMessage=o?.message||"Order created successfully.",this.messageService.add({severity:"success",summary:"Success",detail:this.successMessage}),this.orderItems=[],this.orderComments=""},error:o=>{console.error("Error creating order:",o);let s=o?.error?.message||(o?.error?.errors&&Array.isArray(o.error.errors)?o.error.errors.map(i=>`${i.field||"Error"}: ${i.message||i}`).join(", "):null)||"Failed to create order. Please try again.";this.errorMessage=s,this.messageService.add({severity:"error",summary:"Error",detail:s})}})}static \u0275fac=function(t){return new(t||e)};static \u0275cmp=T({type:e,selectors:[["app-camp-place-order"]],features:[P([L])],decls:26,vars:11,consts:[[1,"camp-place-order-container"],["header","Camp - Place Order"],[1,"form-container"],[1,"field-row"],[1,"field","flex-1"],["for","camp"],[1,"red-star"],["id","camp","optionLabel","label","optionValue","value","placeholder","Select Camp","appendTo","body",1,"w-full",3,"ngModelChange","onChange","onClear","ngModel","options","showClear","disabled"],["class","loading-text",4,"ngIf"],["for","comments"],["id","comments","pInputText","","placeholder","Add comments for this order",1,"w-full",3,"ngModelChange","ngModel"],["severity","error",3,"text",4,"ngIf"],["severity","success",3,"text",4,"ngIf"],[1,"section"],[1,"section-header"],["label","Add Medicine","icon","pi pi-plus",3,"onClick","text"],[3,"value",4,"ngIf"],[1,"actions"],["label","Create Order",3,"onClick","disabled"],[1,"loading-text"],["severity","error",3,"text"],["severity","success",3,"text"],[3,"value"],["pTemplate","header"],["pTemplate","body"],["pTemplate","emptymessage"],[2,"width","40%"],[2,"width","15%"],[2,"width","5%"],["optionLabel","label","optionValue","value","placeholder","Select Supplier","appendTo","body",1,"w-full",3,"ngModelChange","onChange","ngModel","options"],["optionLabel","label","optionValue","value","placeholder","Select Medicine","appendTo","body",1,"w-full",3,"ngModelChange","onChange","ngModel","options"],["mode","decimal",1,"w-full",3,"ngModelChange","ngModel","min","showButtons"],["icon","pi pi-trash","severity","danger",3,"onClick","text"],["colspan","4",2,"text-align","center","padding","12px"]],template:function(t,o){t&1&&(r(0,"div",0),h(1,"p-toast"),r(2,"p-card",1)(3,"div",2)(4,"div",3)(5,"div",4)(6,"label",5),g(7,"Select Camp "),r(8,"span",6),g(9,"*"),l()(),r(10,"p-dropdown",7),v("ngModelChange",function(i){return x(o.selectedCampId,i)||(o.selectedCampId=i),i}),C("onChange",function(){return o.onCampChange()})("onClear",function(){return o.clearSelection()}),l(),m(11,ct,2,0,"small",8),l(),r(12,"div",4)(13,"label",9),g(14,"Comments"),l(),r(15,"input",10),v("ngModelChange",function(i){return x(o.orderComments,i)||(o.orderComments=i),i}),l()()(),m(16,pt,1,1,"p-message",11)(17,mt,1,1,"p-message",12),r(18,"div",13)(19,"div",14)(20,"h4"),g(21,"Medicines"),l(),r(22,"p-button",15),C("onClick",function(){return o.addMedicineRow()}),l()(),m(23,_t,4,1,"p-table",16),l(),r(24,"div",17)(25,"p-button",18),C("onClick",function(){return o.createOrder()}),l()()()()()),t&2&&(c(10),y("ngModel",o.selectedCampId),a("options",o.campOptions)("showClear",!0)("disabled",o.loading),c(),a("ngIf",o.loading),c(4),y("ngModel",o.orderComments),c(),a("ngIf",o.errorMessage),c(),a("ngIf",o.successMessage),c(5),a("text",!0),c(),a("ngIf",o.orderItems.length>0),c(2),a("disabled",!o.selectedCampId||o.loading))},dependencies:[k,S,be,fe,he,Ce,_e,ue,z,Pe,Oe,de,ge,Ee,R,$e,Te,Ie,Me,we,ve,xe,ye],styles:[".camp-place-order-container[_ngcontent-%COMP%]   .form-container[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:16px}.camp-place-order-container[_ngcontent-%COMP%]   .field-row[_ngcontent-%COMP%]{display:flex;flex-direction:row;gap:12px}.camp-place-order-container[_ngcontent-%COMP%]   .flex-1[_ngcontent-%COMP%]{width:50%}.camp-place-order-container[_ngcontent-%COMP%]   .field[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:8px}.camp-place-order-container[_ngcontent-%COMP%]   .field[_ngcontent-%COMP%]   label[_ngcontent-%COMP%]{font-weight:600}.camp-place-order-container[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{display:flex;justify-content:flex-start;gap:12px}.camp-place-order-container[_ngcontent-%COMP%]   .loading-text[_ngcontent-%COMP%]{color:#6c757d}.camp-place-order-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]{display:flex;flex-direction:column;gap:12px}.camp-place-order-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]   .section-header[_ngcontent-%COMP%]{display:flex;align-items:center;justify-content:space-between;gap:12px}.camp-place-order-container[_ngcontent-%COMP%]   .section[_ngcontent-%COMP%]   .section-header[_ngcontent-%COMP%]   h4[_ngcontent-%COMP%]{margin:0}"]})};export{Ae as CampPlaceOrderComponent};
